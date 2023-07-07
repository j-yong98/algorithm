package others;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Problem166 {
    int T;
    int k;
    String str;
    Set<String> set = new HashSet<>();
    List<String> list = new ArrayList<>();
    public void solution() throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            k = Integer.parseInt(br.readLine());
            str = br.readLine();
            set.clear();
            list.clear();
            for (int i = 0; i < str.length(); i++) {
                String tmp = "";
                for (int j = i; j < str.length(); j++) {
                    tmp += str.charAt(j);
                    if (set.contains(tmp)) continue;
                    list.add(tmp);
                    set.add(tmp);
                }
            }
            Collections.sort(list);
            String ans = k > list.size() ? "none" : list.get(k - 1);
            bw.write("#" + t + " " + ans + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
