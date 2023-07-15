package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ4889Test {
    @Test
    void solution() throws IOException {
        BOJ4889 boj4889 = new BOJ4889();
        String p = "}{\n" +
                "{}{}{}\n" +
                "{{{}\n" +
                "---";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj4889.solution();
    }
}