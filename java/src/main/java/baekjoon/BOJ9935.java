package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문자열 폭발
 * 처음에는 그냥 현재 문자열에 폭발 문자열에 포함 되어 있으면 다 삭제하는 식으로 풀이했다.
 * 하지만 문제를 다시 읽어 보니 현재 문자열에서 폭발 문자열과 일치하는 문자를 삭제하고 새로운 문자열로 되풀이하는 방식이었다.
 * 풀이를 문자를 StringBuilder sb에 한자씩 추가하는데 sb의 길이가 폭발 문자열의 길이보다 같거나 커지면
 * sb의 뒤의 문자를 폭발 문자열과 비교해서 같으면 삭제하는 방식으로 구현하였다.
 */
public class BOJ9935 {
    String str;
    String boomStr;
    StringBuilder sb = new StringBuilder();
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        boomStr = br.readLine();
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            sb.append(c);
            if (sb.length() >= boomStr.length()) {
                boolean flag = true;
                for (int j = 0; j < boomStr.length(); j++) {
                    char c1 = sb.charAt(sb.length() - boomStr.length() + j);
                    char c2 = boomStr.charAt(j);
                    if (c1 != c2) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    sb.delete(sb.length() - boomStr.length(), sb.length());
            }
        }
        System.out.println(sb.length() > 0 ? sb : "FRULA");
    }
}
