package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ15684 {
    int n,m,h;

    List<int[]> lines = new ArrayList<>();

    List<int[]> selectedLines = new ArrayList<>();

    int ans = Integer.MAX_VALUE;

    private List<int[]> merge(List<int[]> lines, List<int[]> selectedLines){
        List<int[]> tmp = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++){
            tmp.add(lines.get(i));
        }
        for (int i = 0; i < selectedLines.size(); i++){
            tmp.add(selectedLines.get(i));
        }
        return tmp;
    }
    private boolean getRes(int[] res){
        for (int i = 0; i < res.length; i++){
            if (res[i] != i) return false;
        }
        return true;
    }
    private void print(int[] res){
        for (int re : res) {
            System.out.print(re+" ");
        }
        System.out.println(selectedLines.size());
    }
    private boolean calc(){
        List<int[]> mergeLines = merge(lines,selectedLines);
        int[] res = new int[n];
        for (int i = 0; i < n; i++){
            res[i] = i;
        }
        Collections.sort(mergeLines, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]) return o1[1] - o2[1];
                    return o1[0] - o2[0];
                }
        });
        for (int i = 0; i < mergeLines.size(); i++){
            int line = mergeLines.get(i)[1];
            int tmp = res[line];
            res[line] = res[line+1];
            res[line + 1] = tmp;
        }
//        print(res);
        if (getRes(res)) return true;
        return false;
    }
    private boolean contains(List<int[]> lines, int[] line){
        for (int[] ints : lines) {
            if (ints[0] == line[0] && ints[1] == line[1]) return true;
        }
        return false;
    }
    private void f(int l){
        if (selectedLines.size() > 3 || selectedLines.size() >= ans) return;
        if (l == h) {
            if (calc()){
                ans = Math.min(ans,selectedLines.size());
            }
            return;
        }
        for (int i = 0; i < n-1;i++){
            f(l+1);
            int[] line = new int[]{l,i};
            if (contains(lines,line)) continue;
            selectedLines.add(line);
            f(l+1);
            selectedLines.remove(line);
        }
    }
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        // a = floor, b ~ b+1 연결
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            lines.add(new int[]{a,b});
        }
        f(0);
        if (ans == Integer.MAX_VALUE || ans > 3) {
            ans = -1;
        }
        System.out.println(ans);
        return ans;
    }
}
