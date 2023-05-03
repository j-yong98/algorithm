package others;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem145 {
    int T;
    HashMap<Character, Character> map = new HashMap<>();
    /**
     * 문자열의 거울상
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        map.put('b', 'd');
        map.put('d', 'b');
        map.put('p', 'q');
        map.put('q', 'p');
        for (int t = 1; t <= T; t++) {
            char[] str = br.readLine().toCharArray();
            String ans = "";
            for (int i = str.length - 1; i >= 0; i--)
                ans += map.get(str[i]);
            ans += "\n";
            bw.write("#" + t + " " + ans);
        }
        bw.flush();
        bw.close();
    }
}
