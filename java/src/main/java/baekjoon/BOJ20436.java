package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20436 {
    final char[] LEFT_KEY = {'q', 'w', 'e', 'r', 't', 'a', 's', 'd', 'f', 'g', 'z', 'x', 'c', 'v'};
    final char[][] KEY_BOARD = {
            {'q', 'w', 'e', 'r', 't','y', 'u', 'i', 'o', 'p'},
            {'a', 's', 'd', 'f', 'g','h', 'j', 'k', 'l' },
            {'z', 'x', 'c', 'v', 'b', 'n', 'm'}
    };
    char left;
    char right;
    String str;

    /**
     * ZOAC3
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        left = st.nextToken().charAt(0);
        right = st.nextToken().charAt(0);
        str = br.readLine();
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            int[] pos;
            int[] targetPos = findChar(str.charAt(i));
            if (isLeft(str.charAt(i))) {
                pos = findChar(left);
                left = str.charAt(i);
            }
            else {
                pos = findChar(right);
                right = str.charAt(i);
            }
            ans += getDist(pos, targetPos) + 1;
        }
        System.out.println(ans);
        br.close();
    }

    private boolean isLeft(char c) {
        for (int i = 0; i < LEFT_KEY.length; i++) {
            if (LEFT_KEY[i] == c) return true;
        }
        return false;
    }

    private int getDist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    private int[] findChar(char c) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < KEY_BOARD[i].length; j++) {
                if (KEY_BOARD[i][j] == c)
                    return new int[]{i, j};
            }
        }
        return null;
    }
}
