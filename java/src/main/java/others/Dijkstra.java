package others;

import java.util.*;

public class Dijkstra {
    final int INF = 999999;
    List<List<Node>> graph;
    class Node implements Comparable<Node>{
        int idx;
        int dist;

        public Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node n){
            if (this.dist < n.dist){
                return -1;
            }
            return 1;
        }
    }
    private void makeGraph(int n, int[][] edges){
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++){
            graph.get(edges[i][0]).add(new Node(edges[i][1],edges[i][2]));
            graph.get(edges[i][1]).add(new Node(edges[i][0],edges[i][2]));
        }
    }
    public int[] dijkstra(int n, int[][] edges,int start){
        int[] dist = new int[n+1];
        for (int i = 1; i <= n; i++){
            dist[i] = INF;
        }
        makeGraph(n,edges);

        PriorityQueue<Node> q = new PriorityQueue<>();
        dist[start] = 0;
        q.add(new Node(start,0));

        while (!q.isEmpty()){
            Node now = q.poll();

            if (now.dist > dist[now.idx]) continue;
            for (Node v : graph.get(now.idx)){
                int cost = dist[now.idx] + v.dist;
                if (cost < dist[v.idx]){
                    dist[v.idx] = cost;
                    q.add(new Node(v.idx,dist[v.idx]));
                }
            }
        }
        return dist;
    }
}
