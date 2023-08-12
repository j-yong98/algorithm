package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1062Test {
    @Test
    void solution() throws IOException {
        BOJ1062 boj1062 = new BOJ1062();
        String p = "9 8\n" +
                "antabtica\n" +
                "antaxtica\n" +
                "antadtica\n" +
                "antaetica\n" +
                "antaftica\n" +
                "antagtica\n" +
                "antahtica\n" +
                "antajtica\n" +
                "antaktica";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1062.solution();
    }
}