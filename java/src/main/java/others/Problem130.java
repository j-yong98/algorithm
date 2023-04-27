package others;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem130 {
    int T;
    /**
     * 반반
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            String ans = "No\n";
            Set<Character> set = new HashSet<>();
            char[] arr = br.readLine().toCharArray();
            for (char c : arr)
                set.add(c);
            if (set.size() == 2)
                ans = "Yes\n";
            bw.write("#" + t + " " + ans);
        }
        bw.flush();
        bw.close();
    }
}
