package tree.binary;

import org.junit.jupiter.api.Test;
import tree.TreeNode;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class MorrisTraversalTest {
    @Test
    public void happyPath(){
        TreeNode root = TreeNode.buildNodeFromArray(List.of(4, 2, 5, 1, 3));
        List<Integer> result = MorrisTraversal.traversal(root);
        assertThat(result).containsExactly(1, 2, 3, 4, 5);
    }

    @Test
    public void happyPath2(){
        TreeNode root = TreeNode.buildNodeFromArray(List.of(40, 30, 50, 25, 35, 45, 60));
        List<Integer> result = MorrisTraversal.traversal(root);
        assertThat(result).containsExactly(25, 30, 35, 40, 45, 50, 60);
    }
}
