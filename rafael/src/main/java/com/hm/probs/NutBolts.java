package com.hm.probs;

import java.util.ArrayList;
import java.util.List;

public class NutBolts {

    public static void main(String[] args) {
        Node door = new Node("Door");

        Node w1 = new Node("Washer");
        Node w2 = new Node("Washer");
        Node hinge1 = new Node("Hinge");
        Node nut1 = new Node("Nut");
        nut1.children.add(w1);
        nut1.children.add(w2);
        hinge1.children.add(nut1);
        door.children.add(hinge1);

        Node w3 = new Node("Washer");
        Node w4 = new Node("Washer");
        Node nut2 = new Node("Nut");
        Node nut3 = new Node("Nut");
        Node hinge2 = new Node("Hinge");
        nut1.children.add(w3);
        nut3.children.add(w4);
        hinge2.children.add(nut2);
        hinge2.children.add(nut3);
        door.children.add(hinge2);

        int res = calc(door, "Hinge");
        System.out.println("Res: "+res);
    }

    private static int calc(Node root, String target) {
        List<Node> totalTargets = new ArrayList<>();
        if (root.type.equals(target)) {
            return 1;
        }
        util(root.children, target, totalTargets);
        return totalTargets.size();
    }

    private static void util(List<Node> nodes, String target, List<Node> totalTargets) {
        for(Node node : nodes) {
            if(node.type.equals(target)) {
                totalTargets.add(node);
                //return; exhaustive search only
            }else {
                util(node.children, target, totalTargets);
            }
        }
    }

}

class Node {
    String type;
    List<Node> children;
    public Node(String type) {
        this.type = type;
        this.children = new ArrayList<>();
    }
}
