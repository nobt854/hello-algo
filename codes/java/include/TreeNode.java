/*
 * File: TreeNode.java
 * Created Time: 2022-11-25
 * Author: Krahets (krahets@163.com)
 */

package include;

import java.util.*;

/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    public int val;        // 结点值
    public int height;     // 结点高度
    public TreeNode left;  // 左子结点引用
    public TreeNode right; // 右子结点引用

    public TreeNode(int x) {
        val = x;
    }

    /**
     * Generate a binary tree with an array
     * @param arr
     * @return
     */
    public static TreeNode arrToTree(Integer[] arr) {
        if (arr.length == 0)
            return null;
        
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{ add(root); }};
        int i = 1;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(arr[i] != null) {
                node.left = new TreeNode(arr[i]);
                queue.add(node.left);
            }
            i++;
            if(arr[i] != null) {
                node.right = new TreeNode(arr[i]);
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

    /**
     * Serialize a binary tree to a list
     * @param root
     * @return
     */
    public static List<Integer> treeToList(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{ add(root); }};
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node != null) {
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            else {
                list.add(null);
            }
        }
        return list;
    }
    
    /**
     * Get a tree node with specific value in a binary tree
     * @param root
     * @param val
     * @return
     */
    public static TreeNode getTreeNode(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.val == val)
            return root;
        TreeNode left = getTreeNode(root.left, val);
        TreeNode right = getTreeNode(root.right, val);
        return left != null ? left : right;
    }
}
