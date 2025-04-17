package tree.binary;

import org.junit.jupiter.api.Test;
import tree.TreeNode;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class KthSmallestInBSTTest {
    @Test
    public void happyPath(){
        TreeNode root = TreeNode.buildNodeFromArray(List.of(4,3,5,2));
        int result = KthSmallestInBST.kthSmallest(root, 4);
        assertThat(result).isEqualTo(5);
    }
}
