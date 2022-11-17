import java.io.*;
import java.util.*;


public class PQTutorial {
    public static void main(String[] args) {
        Queue<Order> pq = new PriorityQueue<>(new OrderValueComp());
        pq.offer(new Order(1, 10.5));
        pq.offer(new Order(2, 11));
        pq.offer(new Order(3, 12.5123));

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    static class Order {
        private int seqNo;
        public double value;

        public Order(int seqNo, double value) {
            this.seqNo = seqNo;
            this.value = value;
        }

        public double getValue() {
            return value;
        }

//        @Override
//        public int compareTo(Order other) {
//            return other.seqNo - this.seqNo;
//        }

        @Override
        public String toString() {
            return "Order #" + seqNo + " costs " + value;
        }
    }

    static class OrderValueComp implements Comparator<Order> {
        @Override
        public int compare(Order o1, Order o2) {
            return Double.compare(o2.value, o1.value);
        }
    }
}
