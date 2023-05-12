package baekjoon;

import baekjoon.BOJ15898.Matter;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BOJ15898Test {
    @Test
    void solution() throws IOException {
        BOJ15898 boj15898 = new BOJ15898();
        String p = "4\n" +
                "6 3 3 -9\n" +
                "-6 8 -6 8\n" +
                "9 5 1 -1\n" +
                "-8 2 -3 -1\n" +
                "R B G Y\n" +
                "Y B R R\n" +
                "W R R R\n" +
                "G R W B\n" +
                "-6 -2 -4 -3\n" +
                "1 -3 0 9\n" +
                "8 -7 2 0\n" +
                "0 3 -5 7\n" +
                "W B R Y\n" +
                "Y W R B\n" +
                "W B G G\n" +
                "Y G B R\n" +
                "8 7 2 1\n" +
                "-9 8 8 -9\n" +
                "-1 -4 8 6\n" +
                "-7 8 -3 8\n" +
                "Y W W G\n" +
                "Y B R B\n" +
                "Y W R R\n" +
                "R Y W Y\n" +
                "4 -5 8 3\n" +
                "2 3 1 3\n" +
                "-5 0 1 -3\n" +
                "4 3 3 -6\n" +
                "W Y G W\n" +
                "G G R W\n" +
                "G Y G R\n" +
                "R R G Y";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        long start = System.currentTimeMillis();
        boj15898.solution();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    @Test
    void rotateTest() {
        int[][] arr = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[j][3 - i - 1] + " ");
            }
            System.out.println();
        }
    }
}