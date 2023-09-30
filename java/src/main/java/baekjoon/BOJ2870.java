package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BOJ2870 {
    int N;
    List<String> ans = new ArrayList<>();
    /**
     * 수학숙제
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            StringBuilder sb = new StringBuilder();
            int idx = 0;
            while (idx < str.length()) {
                char c = str.charAt(idx);
                if (c >= '0' && c <= '9')
                    sb.append(c);
                else {
                    if (sb.length() != 0) {
                        ans.add(removeZero(sb.toString()));
                        sb.setLength(0);
                    }
                }
                idx++;
            }
            if (sb.length() != 0)
                ans.add(removeZero(sb.toString()));
        }
        Collections.sort(ans, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length())
                    return o1.length() < o2.length() ? -1 : 1;
                else {
                    for (int i = 0; i < o1.length(); i++) {
                        if (o1.charAt(i) != o2.charAt(i))
                            return Character.compare(o1.charAt(i), o2.charAt(i));
                    }
                }
                return 1;
            }
        });
        ans.stream().forEach(System.out::println);
        br.close();
    }

    private String removeZero(String str) {
        int idx = 0;
        while (str.length() - idx > 1 && str.charAt(idx) == '0')
            idx++;
        return str.substring(idx);
    }
}
