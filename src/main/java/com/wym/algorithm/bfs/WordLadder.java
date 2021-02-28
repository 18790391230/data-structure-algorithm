package com.wym.algorithm.bfs;

import java.util.*;

/**
 * 单词梯
 */
public class WordLadder {

    public static void main(String[] args) {
        HashSet<String> dict = new HashSet<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        int length = ladderLength("hit", "cog", dict);

        System.out.println(length);


    }


    private static int ladderLength(String start, String end, Set<String> dict) {

        int step = 1;
        dict.add(end);
        Queue<String> queue = new LinkedList<>();
        Set<String> duplicate = new HashSet<>();
        duplicate.add(start);
        queue.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                List<String> candidates = getCandidates(poll, dict);
                for (String next : candidates) {
                    if (duplicate.contains(next)) {
                        continue;
                    }
                    if (next.equals(end)) {
                        return step;
                    }
                    duplicate.add(next);
                    queue.add(next);
                }
            }
        }

        return -1;
    }

    private static List<String> getCandidates(String poll, Set<String> dict) {

        List<String> list = new ArrayList<>();

        for (char i = 'a'; i <= 'z'; i++) {
            for (int j = 0; j < poll.length(); j++) {
                String potentialWord = changedWord(i, j, poll);
                if (dict.contains(potentialWord)) {
                    list.add(potentialWord);
                }
            }
        }
        return list;
    }

    private static String changedWord(char i, int j, String poll) {
        char[] chars = poll.toCharArray();
        chars[j] = i;
        return new String(chars);
    }

}
