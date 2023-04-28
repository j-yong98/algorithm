package others;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem134 {
    class Jewel implements Comparable<Jewel>{
        int w;
        int v;
        double value;

        public Jewel(int w, int v, double value) {
            this.w = w;
            this.v = v;
            this.value = value;
        }

        @Override
        public int compareTo(Jewel o) {
            return Double.compare(o.value, this.value);
        }
    }
    int n, m;
    Jewel[] arr;
    double ans = 0;
    /**
     * 쪼개어 배낭 채우기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new Jewel[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            double val = (double) v / w;
            arr[i] = new Jewel(w, v, val);
        }
        Arrays.sort(arr);
        int weight = 0;
        for (int i = 0; i < n; i++) {
            if (weight + arr[i].w > m) {
                double x = (double)(m - weight) / arr[i].w;
                ans += x * arr[i].v;
                break ;
            }
            ans += arr[i].v;
            weight += arr[i].w;
        }
        bw.write(String.format("%.3f",ans) + "\n");
        bw.flush();
        bw.close();
    }
}
