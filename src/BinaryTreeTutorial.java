public class BinaryTreeTutorial {
    public static void main(String[] args) {

    }
}

class Node<T> {
    private T data;
    private Node<T> right;
    private Node<T> parent;
    private Node<T> left;

    public Node(T data) {
        this.data = data;
    }

    public void setRight(Node<T> right) {
        this.right = right;
        right.parent = this;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
        left.parent = this;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public void print() {
        System.out.println(this.data);
    }
}


class IntBinTree {
    private Node<Integer> root;

    private void buildTreeExample() {
        Node<Integer> n1 = new Node<>(12);
        Node<Integer> n2 = new Node<>(49);
        Node<Integer> n3 = new Node<>(42);
        Node<Integer> n4 = new Node<>(13);
        Node<Integer> n5 = new Node<>(5);

        n1.setLeft(n2);
        n1.setRight(n3);

        n2.setLeft(n4);
        n2.setRight(n5);
    }

    public void preOrder(Node<Integer> node) {
        node.print();

    }
}