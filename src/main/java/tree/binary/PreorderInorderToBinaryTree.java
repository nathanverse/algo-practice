package tree.binary;


import tree.TreeNode;

import java.util.Arrays;
import java.util.HashMap;

class PreorderInorderToBinaryTree {
    public static int[] sliceArray(int[] array, int start, int end) {
        // Handle invalid input scenarios
        if (array == null || start < 0 || end > array.length || start >= end) {
            return new int[0]; // Return an empty array
        }

        // Use Arrays.copyOfRange() to create the sub-array
        return Arrays.copyOfRange(array, start, end);
    }



    static HashMap<Integer, Integer> nodeIndexMap = new HashMap<>();
    static int pre_idx = 0;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0 || inorder.length != preorder.length){
            return null;
        }

        for(int i = 0; i< inorder.length; i++){
            nodeIndexMap.put(inorder[i], i);
        }

        return buildTreeRecursive(preorder, 0, inorder.length -1);
    }

    public static TreeNode buildTreeRecursive(int[] preorder, int left, int right){
        if(left > right){
            return null;
        }

        if(left == right){
            return new TreeNode(preorder[pre_idx++]);
        }

        TreeNode root = new TreeNode(preorder[pre_idx++]);
        root.left = buildTreeRecursive(preorder, left, nodeIndexMap.get(root.val) - 1);
        root.right = buildTreeRecursive(preorder, nodeIndexMap.get(root.val) + 1, right);

        return root;
    }
}
