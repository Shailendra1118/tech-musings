import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.Map;

public class TestClass {
    public static void main(String[] args) {
        //URL
        // Node (URL, IP addr)
        Map<String, String> mapA = new HashMap<>();
        mapA.put("www.google.com", "111.111.111.555");
        mapA.put("www.yahoo.com", "111.111.111.333");
        Map<String, String> mapB = new HashMap<>();
        mapB.put("www.bbc.com", "111.111.111.444");
        Map<String, String> mapC = new HashMap<>();
        TreeNode nodeA = new TreeNode(mapA, null);
        TreeNode nodeB = new TreeNode(mapB, nodeA);
        TreeNode nodeC = new TreeNode(mapC, nodeB);


        String input = "www.bbc.com";
        String output = findIPAddress(input, nodeC);
        System.out.println("Output: "+output);

    }

    private static String findIPAddress(String input, TreeNode node) {
        //base condition
        if(node == null) {
            return "";
        }
        if(node.map.containsKey(input)) {
            return node.map.get(input);
        } else {
            //current node doesn't have entry
            return findIPAddress(input, node.parent);
        }
    }

    static class TreeNode {
        Map<String, String> map;
        TreeNode parent;

        public TreeNode(Map<String, String> map, TreeNode parent) {
            this.map = map;
            this.parent = parent;
        }
    }
}
