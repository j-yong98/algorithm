package others;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem168 {
    int T;
    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int k = Integer.parseInt(br.readLine());
            String str = br.readLine();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                String sub = str.substring(i, str.length());
                list.add(sub);
            }
            Collections.sort(list);
            bw.write("#" + t + " " + list.get(k - 1) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
