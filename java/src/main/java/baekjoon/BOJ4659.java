package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ4659 {
    final String vowel = "aeiou";
    /**
     * 비밀번호 발음하기
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (str.equals("end")) break;
            boolean first = false;
            boolean second = true;
            boolean third = true;

            for (int i = 0; i < str.length(); i++) {
                String s = String.valueOf(str.charAt(i));
                if (!vowel.contains(s)) continue;
                first = true;
                break;
            }

            for (int i = 0; i < str.length(); i++) {
                if (i + 3 > str.length()) continue;
                int v = 0;
                int c = 0;
                for (int j = i; j < i + 3; j++) {
                    String s = String.valueOf(str.charAt(j));
                    if (vowel.contains(s)) v += 1;
                    else c += 1;
                }
                if (v == 0 || c == 0) {
                    second = false;
                    break;
                }
            }

            for (int i = 1; i < str.length(); i++) {
                char c1 = str.charAt(i - 1);
                char c2 = str.charAt(i);
                if (c1 == 'e' && c2 == 'e' || c1 == 'o' && c2 == 'o') continue;
                if (c1 == c2) {
                    third = false;
                    break;
                }
            }
            if (first && second && third)
                sb.append("<").append(str).append("> is acceptable.\n");
            else
                sb.append("<").append(str).append("> is not acceptable.\n");
        }
        System.out.print(sb);
        br.close();
    }
}
