package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Problem83 {
    class PartTime{
        int start;
        int end;
        int pay;

        public PartTime(int start, int end, int pay) {
            this.start = start;
            this.end = end;
            this.pay = pay;
        }
    }
    int n;
    PartTime[] partTimes;
    int[] d;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        partTimes = new PartTime[n];
        d = new int[n];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int pay = Integer.parseInt(st.nextToken());
            partTimes[i] = new PartTime(s,e,pay);
        }
        Arrays.sort(partTimes, new Comparator<PartTime>() {
            @Override
            public int compare(PartTime o1, PartTime o2) {
                return o1.start - o2.start;
            }
        });
        for (int i = 0; i < n; i++){
            d[i] = partTimes[i].pay;

            for (int j = 0; j < i; j++){
                int preEnd = partTimes[j].end;
                int nextStart = partTimes[i].start;
                if (preEnd < nextStart){
                    d[i] = Math.max(d[i],d[j] + partTimes[i].pay);
                }
            }
        }
        System.out.println(Arrays.stream(d).max().getAsInt());
    }
}
