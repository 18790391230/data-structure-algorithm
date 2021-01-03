package com.wym.tree;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

/**
 * 霍夫曼编码
 * 是霍夫曼树的一种应用，数据中重复字符最多的字符用较短的数据来描述，重复次数较少的字符用较长的数据来描述，
 * 需要保存一种映射，比如：a:001 表示a的在霍夫曼树中的路径是先向左，再向左，再向右
 *
 *
 */
public class HuffmanCode {

    private static Map<Byte, String> codeMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        zipFile();

        unzipFile();
    }

    private static void unzipFile()throws Exception {

        String srcPath = "D:\\core.zip";
        String destPath = "D:\\corebak.yaml";
        try (FileInputStream fis = new FileInputStream(srcPath)) {
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                //读取压缩文件数据部分
                byte[] huffmanBytes = (byte[]) ois.readObject();

                //读取编码映射
                Map<Byte, String> huffmanCodeMap = (Map<Byte, String>) ois.readObject();

                //解码
                byte[] srcBytes = decode(huffmanBytes, huffmanCodeMap);

                //写入文件
                try(final FileOutputStream fos = new FileOutputStream(destPath)) {
                    fos.write(srcBytes);
                }
            }



        }

    }

    private static byte[] decode(byte[] huffmanBytes, Map<Byte, String> huffmanCodeMap) {

        //Byte转bit
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < huffmanBytes.length - 1; i++) {
            sb.append(byte2BitString(true, huffmanBytes[i]));
        }
        sb.append(byte2BitString(false, huffmanBytes[huffmanBytes.length - 1]));

        //翻转map
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodeMap.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }

        //解码数据
        List<Byte> list = new ArrayList<>();
        int index = 0;
        Byte val = null;
        for (int i = 0; i < sb.length(); i++) {
            final String key = sb.substring(index, i + 1);
            if ((val = map.get(key)) != null) {
                list.add(val);
                index = i + 1;
            }
        }
        byte[] rtnByte = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            rtnByte[i] = list.get(i);
        }

        return rtnByte;
    }

    private static String byte2BitString(boolean b, byte huffmanByte) {

        int temp = huffmanByte;
        if (b) {
            temp |= 256;
        }
        final String str = Integer.toBinaryString(temp);
        if (b) {
            return str.substring(str.length() - 8);
        }

        return str;
    }

    private static void zipFile() throws Exception {

        String srcPath = "D:\\core.yaml";
        String destPath = "D:\\core.zip";
        try (FileInputStream fis = new FileInputStream(srcPath)) {
            //读取数据
            final byte[] bytes = new byte[fis.available()];
            fis.read(bytes);

            //压缩
            byte[] huffmanCodeBytes = doZip(bytes);

            //压缩后数据写入文件
            try (final FileOutputStream fos = new FileOutputStream(destPath)) {

                try(ObjectOutputStream oos = new ObjectOutputStream(fos)) {

                    oos.writeObject(huffmanCodeBytes);

                    //编码规则写入文件
                    oos.writeObject(codeMap);
                }
            }

        }
        System.out.println("压缩成功");
    }


    private static byte[] doZip(byte[] contentBytes) {
//        //1.给定一个字符串，转为字节数组
//        String source = "i like like like java do you like a java";
//        byte[] contentBytes = source.getBytes();

        //2.计算字符串中每个字符出现的次数

        Map<Byte, Integer> map = new HashMap<>();
        for (byte b : contentBytes) {
            Integer val = map.putIfAbsent(b, 1);
            if (val != null) {
                map.put(b, val + 1);
            }
        }


        //3.将第2步得到的映射关系保存到node中（霍夫曼树）
        Node root = buildTree(map);
        root.preOrder();

        //4.根据霍夫曼树计算每个叶子节点的路径，向左是0，向右是1
        buildCodeMap(root, codeMap, "", "");
        System.out.println(codeMap);

        //5.遍历字节数组，根据上一步得到的霍夫曼编码进行转换
        return buildHuffmanCodes(contentBytes, codeMap);
    }

    private static byte[] buildHuffmanCodes(byte[] contentBytes, Map<Byte, String> codeMap) {

        //1.遍历字节数组，得到内容对应的霍夫曼编码
        StringBuilder sb = new StringBuilder();
        for (byte b : contentBytes) {
            sb.append(codeMap.get(b));
        }
        int len = sb.length() % 8 == 0 ? sb.length() / 8 : sb.length() / 8 + 1;
        byte[] huffmanCodeBytes = new byte[len];

        //2.八个字符作为一个字节，再次转化，得到最终的码
        int index = 0;
        for (int i = 0; i < sb.length(); i+=8) {
            String s = null;
            if (i + 8 > sb.length()) {
                s = sb.substring(i);
            } else {
                s = sb.substring(i, i + 8);
            }
            //将s转为一个byte，放入huffmanCodeBytes
            huffmanCodeBytes[index++] = (byte) Integer.parseInt(s, 2);
        }

        return huffmanCodeBytes;
    }

    private static void buildCodeMap(Node node, Map<Byte, String> codeMap, String code, String prefix) {

        if (node == null) {
            return;
        }

        if (node.b == null) {
            buildCodeMap(node.left, codeMap, "0", prefix + code);
            buildCodeMap(node.right, codeMap, "1", prefix + code);
        } else {
            codeMap.put(node.b, prefix + code);
        }

    }

    private static Node buildTree(Map<Byte, Integer> map) {

        List<Node> list = new ArrayList<>();
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            Node node = new Node(entry.getKey(), entry.getValue());
            list.add(node);
        }

        //1.先排序
        Collections.sort(list);

        while (list.size() > 1) {
            //2.依次获得前两个元素
            Node left = list.get(0);
            Node right = list.get(1);

            //3.创建parent
            Node node = new Node(null, left.weight + right.weight);
            node.left = left;
            node.right = right;

            //4.将parent添加到list，并删除前两个元素
            list.add(node);
            list.remove(left);
            list.remove(right);

            //5.再次排序
            Collections.sort(list);
        }

        return list.get(0);
    }

    static class Node implements Comparable<Node>{
        Node left;
        Node right;

        Byte b;

        int weight = 0;

        public void preOrder() {
            System.out.println(this);
            if (left != null) {
                left.preOrder();
            }
            if (right != null) {
                right.preOrder();
            }
        }

        public Node(Byte b, int weight) {
            this.b = b;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "b=" + b +
                    ", weight=" + weight +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

}
