package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem117Test {
    @Test
    void solution() throws IOException {
        Problem117 problem117 = new Problem117();
        String p = "3\n" +
                "142857\n" +
                "1\n" +
                "1035";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem117.solution();
    }
}