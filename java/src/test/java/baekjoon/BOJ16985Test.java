package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ16985Test {
    @Test
    void rotataTest() {
        BOJ16985 boj16985 = new BOJ16985();
        boj16985.printMap(boj16985.rotate(new int[][] {
                {1,1,1,1,1},
                {1,1,0,0,1},
                {1,1,0,0,1},
                {1,0,0,1,0},
                {0,0,0,0,0}
        }));
    }
    @Test
    void solution() throws IOException {
        BOJ16985 boj16985 = new BOJ16985();
        String p = "0 0 1 0 0\n" +
                "0 0 0 0 0\n" +
                "1 1 0 0 0\n" +
                "0 0 1 0 0\n" +
                "1 1 1 0 0\n" +
                "0 0 0 0 1\n" +
                "1 0 0 0 0\n" +
                "0 1 0 0 1\n" +
                "0 0 0 0 0\n" +
                "0 1 0 1 0\n" +
                "1 0 0 0 1\n" +
                "1 1 1 1 1\n" +
                "1 1 0 0 0\n" +
                "0 0 0 1 0\n" +
                "0 0 0 1 0\n" +
                "0 0 0 1 1\n" +
                "0 0 1 0 0\n" +
                "0 1 1 1 0\n" +
                "1 0 0 0 0\n" +
                "0 1 1 0 1\n" +
                "0 1 0 0 0\n" +
                "0 0 0 1 0\n" +
                "1 0 0 0 0\n" +
                "0 0 0 1 0\n" +
                "0 0 0 1 0";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj16985.solution();
    }
}