package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BOJ1759Test {

    @Test
    void solution() throws IOException {
        BOJ1759 boj1759 = new BOJ1759();
        String p = "4 6\n" +
                "a t c i s w";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1759.solution();
    }

}