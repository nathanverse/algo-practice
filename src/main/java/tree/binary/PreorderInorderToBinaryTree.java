package tree.binary;


import tree.TreeNode;

import java.util.Arrays;

class PreorderInorderToBinaryTree {
    public static int[] sliceArray(int[] array, int start, int end) {
        // Handle invalid input scenarios
        if (array == null || start < 0 || end > array.length || start >= end) {
            return new int[0]; // Return an empty array
        }

        // Use Arrays.copyOfRange() to create the sub-array
        return Arrays.copyOfRange(array, start, end);
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0 || inorder.length != preorder.length){
            return null;
        }

        int root = preorder[0];
        int rootIndexInorder = -1;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == root){
                rootIndexInorder = i;
            }
        }

        TreeNode rootNode = new TreeNode(root);
        if(rootIndexInorder == 1){
            rootNode.left = new TreeNode(inorder[0]);
        } else{
            int [] leftSubtreePreoder = sliceArray(preorder, 1, 1 + rootIndexInorder);
            int [] leftSubtreeInorder = sliceArray(inorder, 0, rootIndexInorder);
            rootNode.left = buildTree(leftSubtreePreoder, leftSubtreeInorder);
        }

        if(inorder.length - rootIndexInorder == 2){
            rootNode.right = new TreeNode(inorder[rootIndexInorder + 1]);
        } else{
            int [] rightSubtreePreoder = sliceArray(preorder, 1 + rootIndexInorder, preorder.length);
            int [] rightSubtreeInorder = sliceArray(inorder, rootIndexInorder + 1, inorder.length);
            rootNode.right = buildTree(rightSubtreePreoder, rightSubtreeInorder);
        }

        return new TreeNode(root);
    }
}
