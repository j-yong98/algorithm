package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ5373Test {
    @Test
    void solution() throws IOException {
        BOJ5373 boj5373 = new BOJ5373();
        String p = "1\n" +
                "5\n" +
                "L- F+ L+ D+ B+";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj5373.solution();
    }

    @Test
    void rotateTest() {
        int[][] arr = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] tmp = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                tmp[j][3 - i - 1] = arr[i][j];
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                System.out.print(tmp[i][j] + " ");
            System.out.println();
        }
    }
}