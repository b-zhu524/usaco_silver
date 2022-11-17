//import java.util.*;
//
//public class TreeTutorial {
//    public static void main(String[] args) {
//        Tree t = new Tree();
//        t.buildTreeExample();
//        t.printTree();
//    }
//}
//
//
//class Node {
//    private String data;
//    private List<Node> children = new ArrayList<>();
//
//    public Node(String d) {
//        data = d;
//    }
//
//
//
//    public void addChild(Node c) {
//        children.add(c);
//    }
//
//    public List<Node> getChildren() {
//        return children;
//    }
//
//    public String getData() {
//        return data;
//    }
//}
//
//
//class Tree {
//    private Node root;
//    private List<Node> leaves;
//
//    public void buildTreeExample() {
//        Node a = new Node("A");
//        Node b = new Node("B");
//        Node c = new Node("C");
//        Node d = new Node("D");
//
//        a.addChild(b);
//        a.addChild(c);
//        a.addChild(d);
//
//        root = a;
//    }
//
//    public void printTree() {
//        System.out.println(this.root.getData());
//        for (Node child : root.getChildren()) {
//            System.out.println("\t" + child.getData());
//        }
//    }
//
//    public void printFromLeaves() {
//        for (Node leaf : leaves) {
//            System.out.print(leaf.getData());
//            System.out.print("->");
//            System.out.println(leaf.get);
//        }
//    }
//}