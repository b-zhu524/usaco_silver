import java.util.*;


public class BinaryTreeDemo {

    private static class Node<T> {
        private T data;
        private Node<T> left;
        private Node<T> right;

        public Node(T data) {
            this.data = data;
            left = null;
            right = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }
    }

    private static class Tree {
        private static Node<Integer> root;

        private static String listToString(List<Integer> l) {
            String s = "";
            for (int i=0; i<l.size(); i++) {
                if (i > 0) {
                    s += " ";
                }
                s += l.get(i);
            }
            return s.toString();
        }

        public static String preOrder() {
            List<Integer> result = new ArrayList<>();
            preOrder(result, root);
            return Tree.listToString(result);
        }

        public static void preOrder(List<Integer> result, Node<Integer> node) {
            if (node==null) {
                return;
            }
            result.add(node.getData());
            preOrder(result, node.getLeft());
            preOrder(result, node.getRight());
        }


//        private Node<Integer> build(int inOrderStart, int inOrderEnd) {
//            return Node<Integer>()
//        }
    }
}

