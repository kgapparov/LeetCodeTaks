package pattern.bst;

public class MaximumDepthBST
{
    //top down approach
    private int ans;
    public int maxDepth (TreeNode root)
    {
         topDown(root, 1);
         return ans;
    }

    private void   topDown(TreeNode root, int param)
    {
        if (root == null)
        {
            return;
        }
        //top down first update unswer then go recursive, because we can already update answer.
        ans = Math.max(ans, param);
        topDown(root.left, param+1);
        topDown(root.right, param+1);
    }


    //Buttom-up solution
    public int maxDepth2(TreeNode root)
    {
        if (root == null) return 0;
        int left = maxDepth2(root.left);
        int right = maxDepth2(root.right);
        return Math.max(left, right) + 1;
    }

}
