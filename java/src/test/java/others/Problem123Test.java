package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem123Test {
    @Test
    void solution() throws IOException {
        Problem123 problem123 = new Problem123();
        String p = "3\n" +
                "2\n" +
                "0 1 0 0 0 0 0\n" +
                "100000\n" +
                "1 0 0 0 1 0 1\n" +
                "9\n" +
                "0 0 1 1 1 1 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem123.solution();
    }
}