package tree.binary;

import java.util.Stack;
import tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class KthSmallestInBST {
    public static int kthSmallest(TreeNode root, int k) {
        if(k <= 0 || root == null){
            return -1;
        }

        TreeNode curNode = root;
        while(curNode != null){
            int curResult = 0;
            if(curNode.left == null){
                k--;
                curResult = curNode.val;
                curNode = curNode.right;
            } else {
                TreeNode rightMostNode = curNode.left;
                while(rightMostNode.right != null && rightMostNode.right != curNode){
                    rightMostNode = rightMostNode.right;
                }

                if(rightMostNode.right == null){
                    rightMostNode.right = curNode;
                    curNode = curNode.left;
                } else {
                    k--;
                    curResult = curNode.val;
                    curNode = curNode.right;
                }
            }

            if(k == 0){
                return curResult;
            }
        }

        return -1;
    }
}
