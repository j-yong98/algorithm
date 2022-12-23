package others;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSorting {
    public int[] topolo(int n, int[][] edges){
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[n+1];
        for (int i = 0; i < edges.length; i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            indegree[edges[i][1]] += 1;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++){
            if (indegree[i] == 0){
                q.add(i);
                indegree[i] = -1;
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            Integer number = q.poll();
            ans.add(number);
            List<Integer> numbers = graph.get(number);
            for (Integer i : numbers) {
                indegree[i] -= 1;
                if (indegree[i] == 0){
                    q.add(i);
                    indegree[i] = -1;
                }
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

}
