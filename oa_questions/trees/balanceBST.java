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
class Solution {
    List<TreeNode> list =new ArrayList<>();
    
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return makeBinaryTree(list);     
    }
    
    public void inorder(TreeNode root){
        if(root==null)
            return;
        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }
    
    public TreeNode makeBinaryTree(List<TreeNode> list){
        if(list.size()==0 || list==null)
            return null;
        int mid=list.size()/2;
        TreeNode root=list.get(mid);
        root.left=makeBinaryTree(list.subList(0,mid));
        root.right=makeBinaryTree(list.subList(mid+1,list.size()));
        return root;
    }
}