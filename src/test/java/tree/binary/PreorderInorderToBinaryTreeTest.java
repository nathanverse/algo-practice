package tree.binary;

import org.junit.jupiter.api.Test;
import tree.TreeNode;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PreorderInorderToBinaryTreeTest {
    @Test
    public void happyPath(){
        int[] preOrder = {1,2,3,4};
        int[] inOrder = {2,1,3,4};
        TreeNode root = PreorderInorderToBinaryTree.buildTree(preOrder, inOrder);
        assertThat(root).isNotNull();
    }
}