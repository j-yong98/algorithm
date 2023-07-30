package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ10866Test {
    @Test
    void solution() throws IOException {
        BOJ10866 boj10866 = new BOJ10866();
        String p = "15\n" +
                "push_back 1\n" +
                "push_front 2\n" +
                "front\n" +
                "back\n" +
                "size\n" +
                "empty\n" +
                "pop_front\n" +
                "pop_back\n" +
                "pop_front\n" +
                "size\n" +
                "empty\n" +
                "pop_back\n" +
                "push_front 3\n" +
                "empty\n" +
                "front";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj10866.solution();
    }
}