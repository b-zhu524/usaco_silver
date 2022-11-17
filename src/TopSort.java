//import java.util.*;
//import java.io.*;
//
//
//public class TopSort {
//    public static void main(String[] args) {
//
//    }
//
//    private void dfs(int v, boolean[] visited) {
//        visited[v] = true;
//        for (Neighbor nbr=adjList[v].adjList; nbr!=null; nbr=nbr.next) {
//            if (!visited[nbr.vertexNum]) {
//                dfs(nbr.vertexNum, visited);
//            }
//        }
//    }
//
//    public class Graph {
//        Vertex[] adjLists;
//    }
//
//    class Vertex {
//        String name;
//        Neighbor adjList;
//        Vertex(String name, Neighbor neighbors) {
//            this.name = name;
//            this.adjList = neighbors;
//        }
//    }
//
//    class Neighbor {
//        public int vertexNum;
//        public Neighbor next;
//        public Neighbor(int vnum, Neighbor nbr) {
//            this.vertexNum = vnum;
//            next = nbr;
//        }
//    }
//}
