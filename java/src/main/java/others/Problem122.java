package others;

import java.io.*;
import java.util.StringTokenizer;

public class Problem122 {
    enum Weekends {
        SUN, MON, TUE, WED, THU, FRI, SAT
    }
    int T;
    /**
     * 일요일
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            Weekends day = Weekends.valueOf(br.readLine());
            bw.write("#" + t + " " + (7 - day.ordinal()) + "\n");
        }
        bw.flush();
        bw.close();
    }
}
