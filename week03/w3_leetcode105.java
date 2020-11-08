class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        _helper(0, inorder.length - 1, 0, preorder, inorder);
    }
    
    public TreeNode _helper(int inStart, int inEnd, int preStart, int[] preorder, int[] inorder){
        if (preStart > preorder.length - 1 || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        
        int inIndex = 0;
        for (int i = inStart; i < inEnd; i++){
            if (preorder[preStart] == inorder[i])
                inIndex = i;
        }
        root.left = _helper(inStart, inIndex-1, preStart+1, preorder, inorder);
        root.right = _helper(inIndex+1, inEnd, preStart + inIndex - inStart + 1, preorder, inorder);
        return root;
    }
}
