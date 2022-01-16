package pattern.bst;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EveryDayTraining {
    //traversals 3 DFS preorder inorder and postorder
    List<Integer> preorderRes = new ArrayList<>();
    List<Integer> inorder = new ArrayList<>();
    List<Integer> postorderRes = new ArrayList<>();
    void dfsPreorder(TreeNode root) {
        if (root == null) {
            return;
        }
        preorderRes.add(root.val);
        dfsPreorder(root.left);
        dfsPreorder(root.right);
    }
    void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        inorder.add(root.val);
        inorder(root.right);
    }
    void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        postorderRes.add(root.val);
    }
    //bfs
    public List<Integer> answer = new LinkedList<>();
     void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            answer.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
     }
    //max Depth of Binary tree
    public int maxDepthBinary(TreeNode root) {
         if (root == null) return 0;
         int left =  maxDepthBinary(root.left);
         int right = maxDepthBinary(root.right);
         return Math.max(left, right) + 1;
    }

    public int maxDepthTopdown(TreeNode root) {
         return maxDepthDfs(root, 0);
    }

    private int maxDepthDfs(TreeNode root, int level) {
         if (root == null) {
             return level;
         }
         int left = maxDepthDfs(root.left, level + 1);
         int right = maxDepthDfs(root.right, level + 1);
         return Math.max(left, right);
    }

    //Symmmetric tree
    private boolean isSymmetric(TreeNode root) {
         if (root == null) return true;

         return isSymmetric1(root.left, root.right);
    }

    private boolean isSymmetric1(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetric1(left.left, right.right) && isSymmetric1(left.right, right.left);
    }


    //Path Sum

    //Binary Search Tree Unipath

    //ConstructBSTInorderPostorder

    //ConstructBSTInorderPreorder

}
