import java.io.*;
import java.util.*;


public class DFSPractice {
    public static void main(String[] args) {
        Set<Integer> visited = new HashSet<>();

        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
    }

    private int bfsDisconnected(Graph g, int start) {
        Set<Integer> visited = new HashSet<>();
        Deque<Integer> queue = new ArrayDeque<>();

        System.out.println(start);

        int numComponents = 0;
        for (int i=0; i<g.numOfNodes; i++) {
            if (!visited.contains(i)) {
                numComponents++;
                bfs(g, i, visited, queue);
            }
        }
        return numComponents;
    }

    private void bfs(Graph g, int start, Set<Integer> visited, Deque<Integer> queue) {
        queue.addLast(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            int s = queue.removeFirst();
            for (int neighbor : g.getAdjList()[s]) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.addLast(neighbor);
                }
                System.out.println(s);
            }
        }
    }



    private static int dfsDisconnected(Set<Integer> visited, Graph g) {
        int numComponents = 0;
        for (int i=0; i< g.numOfNodes; i++) {
            if (!visited.contains(i)) {
                numComponents++;
                dfs(visited, g, i);
            }
        }
        return numComponents;
    }

    private static void dfs(Set<Integer> visited, Graph g, int v) {
        visited.add(v);
        System.out.println(v);

        for (int neighbor : g.getAdjList()[v]) {
            if (visited.contains(neighbor)) {
                continue;
            }
            dfs(visited, g, neighbor);
        }
    }


    private void dfsIterative(Graph g, int start) {
        Set<Integer> visited = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();

        stack.addLast(start);
        visited.add(start);
        System.out.println(start);

        while (!stack.isEmpty()) {
            int s = stack.pop();
            for (int neighbor : g.getAdjList()[s]) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    stack.addLast(neighbor);
                }
                System.out.println(s);
            }
        }
    }


    public static class Graph {
        private List<Integer>[] adjList;

        public List<Integer>[] getAdjList() {
            return adjList;
        }

        public int numOfNodes;

        public Graph(int numOfNodes) {
            this.numOfNodes = numOfNodes;
            adjList = new List[numOfNodes];
            for (int i = 0; i < numOfNodes; i++) {
                adjList[i] = new ArrayList<>();
            }
        }

        public void addEdge(int v1, int v2) {
            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }
    }
}
