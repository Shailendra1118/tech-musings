package mocks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public static void main(String[] args) {

        TreeNode three = new TreeNode(3);
        TreeNode nine = new TreeNode(3);
        TreeNode twenty = new TreeNode(3);
        TreeNode fifteen = new TreeNode(3);
        TreeNode seven = new TreeNode(3);
        three.left = nine;
        three.right = twenty;
        twenty.left = fifteen;
        twenty.right = seven;

        levelOrder(three);
        System.out.println(getHeightAnother(three));
        //System.out.println(levelOrderQueue(three));

    }

    private static List<List<Integer>> levelOrderQueue(TreeNode root) {

        LinkedList<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(! queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            result.addFirst(list);

        }
        return result;
    }

    private static void levelOrder(TreeNode node) {
        Queue<Object[]> que = new LinkedList<>();
        int height = getHeight(node, 1);
        System.out.println("Height: "+height);



    }

    private static int getHeight(TreeNode node, int level) {
        int leftHeight = level;
        int rightHeight = level;
        if(node.left != null) {
            leftHeight = getHeight(node.left, level + 1);
        }
        if(node.right != null) {
            rightHeight = getHeight(node.right, level + 1);
        }
        return Math.max(leftHeight, rightHeight);

    }


    private static int getHeightAnother(TreeNode node) {
       if(node == null)
           return 0;
       int lHeight = getHeightAnother(node.left);
       int rHeight = getHeightAnother(node.right);
       return Math.max(lHeight, rHeight)+1;
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
