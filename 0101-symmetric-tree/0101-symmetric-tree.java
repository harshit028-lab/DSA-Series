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
    public boolean isSymmetric(TreeNode root) {
        return root == null || ism( root.left , root.right);
    }
        
        public boolean ism(TreeNode a, TreeNode b){

        if( a == null && b == null)
        return true;
        if( a == null || b == null)
        return false;
        if(a.val != b.val)
        return false;

        return ism(a.left,b.right)&&ism(b.left,a.right);
              }

}