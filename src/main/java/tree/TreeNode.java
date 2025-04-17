package tree;


import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    private TreeNode buildNodeRecursive(List<Integer> integerList, int curIndex){
        if(curIndex >= integerList.size()){
            return null;
        }
        int leftNodeIndex = curIndex*2 + 1;
        int rightNodeIndex = curIndex*2 + 2;

        TreeNode rootNode = integerList.get(curIndex) == null ? null : new TreeNode(integerList.get(curIndex));
        if(rootNode != null){
            rootNode.left = rootNode.buildNodeRecursive(integerList, leftNodeIndex);
        }
        if (rootNode != null){
            rootNode.right = rootNode.buildNodeRecursive(integerList, rightNodeIndex);
        }
        return rootNode;
    }

    public static TreeNode buildNodeFromArray(List<Integer> integerList){
        if(integerList == null || integerList.isEmpty()){
            return null;
        }

        TreeNode rootNode = new TreeNode(integerList.get(0));
        rootNode.left = rootNode.buildNodeRecursive(integerList, 1);
        rootNode.right = rootNode.buildNodeRecursive(integerList, 2);

        return rootNode;
    }
}