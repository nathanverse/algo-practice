package tree.binary;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Morris traversal helps traverse the BST without the need
 * to use recursion and stack.
 */
public class MorrisTraversal {
    public static List<Integer> traversal(TreeNode root){
        if(root == null){
            return Collections.emptyList();
        }

        TreeNode curNode = root;
        List<Integer> sortedResult = new ArrayList<>();
        while (curNode != null){
            if(curNode.left == null){
                sortedResult.add(curNode.val);
                curNode = curNode.right;
            } else{
                TreeNode rightMostNode = curNode.left;
                while(rightMostNode.right != null && rightMostNode.right != curNode){
                    rightMostNode = rightMostNode.right;
                }

                if(rightMostNode.right == null){
                    rightMostNode.right = curNode;
                    curNode = curNode.left;
                } else{
                    sortedResult.add(curNode.val);
                    curNode = curNode.right;
                }
            }
        }

        return sortedResult;
    }
}
