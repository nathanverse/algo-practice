package tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeTest {
    @Test
    void happyPath(){
        TreeNode root = TreeNode.buildNodeFromArray(List.of(4, 2, 5, 1, 3));
        List<Integer> leftHandSideNode = new ArrayList<>();
        while(root != null){
            leftHandSideNode.add(root.val);
            root = root.left;
        }

        assert(leftHandSideNode.equals(List.of(4, 2, 1)));
    }
}
