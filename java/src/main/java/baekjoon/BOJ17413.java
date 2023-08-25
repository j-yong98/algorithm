package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17413 {
    String str;
    StringBuilder sb = new StringBuilder();

    /**
     * 단어 뒤집기2
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        recursion(0);
        System.out.println(sb);
        br.close();
    }

    private void recursion(int start) {
        if (start >= str.length()) return;
        if (str.charAt(start) == '<') {
            int wordLen = getWordLen(start + 1, ">");
            sb.append("<");
            sb.append(str.substring(start + 1, start + 1 + wordLen));
            sb.append(">");
            recursion(start + wordLen + 2);
        } else {
            int wordLen = getWordLen(start, "< ");
            sb.append(reverse(str.substring(start, start + wordLen).toCharArray()));
            if (start + wordLen < str.length() && str.charAt(start + wordLen) == ' ') {
                sb.append(" ");
                recursion(start + wordLen + 1);
            } else
                recursion(start + wordLen);
        }
    }

    private String reverse(char[] string) {
        int N = string.length;
        for (int i = 0; i < N / 2; i++) {
            char tmp = string[i];
            string[i] = string[N - i - 1];
            string[N - i - 1] = tmp;
        }
        return String.valueOf(string);
    }

    private int getWordLen(int start, String endChar) {
        for (int i = start; i < str.length(); i++) {
            if (endChar.contains(String.valueOf(str.charAt(i))))
                return i - start;
        }
        return str.length() - start;
    }
}
