package com.wym.suixianglu.tree._01_foreachtype.bstproperty;

import javax.swing.tree.TreeNode;
import java.util.Stack;

/**
 * 将二叉搜索树转为累加树
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 */
public class _05ConvertBST2GreaterTree {

    public static void main(String[] args) {
        _04FindMode.TreeNode root = new _04FindMode.TreeNode();
        convert(root);
    }



    static int prev = 0;

    private static void convert(_04FindMode.TreeNode root){
        if(root == null){
            return;
        }
        convert(root.right);
        prev += root.val;
        root.val = prev;
        convert(root.left);

    }

    private static void convert2(_04FindMode.TreeNode root){
        if(root == null){
            return;
        }
        _04FindMode.TreeNode cur = root;
        Stack<_04FindMode.TreeNode> stack = new Stack<>();
        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.add(cur);
                cur = cur.right;
            }else{
                _04FindMode.TreeNode node = stack.pop();
                prev += node.val;
                node.val = prev;
                cur = node.left;
            }
        }
    }


}
