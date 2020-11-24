import java.util.ArrayList;
import java.util.Vector;

public class Test {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
          val = x;
      }
  }
    public static int countNodes(TreeNode root) {
        if(root==null) return 0;
        //完全二叉树求节点，可以考虑使用队列
        ArrayList queue  = new ArrayList();
        //先把root加入队列
        queue.add(root);
        //节点数
        int ans=0;
        //开始求节点
        while(!queue.isEmpty()){
            root = (TreeNode)queue.remove(0);
            ans++;
            //将左右节点加入队列
            if(root.left!=null){
                queue.add(root.left);
            }
            if(root.right!=null){
                queue.add(root.right);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.left=node6;
        node3.right=null;

        System.out.println(countNodes(node1));
    }
}
