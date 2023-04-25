package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem125Test {
    @Test
    void solution() throws IOException {
        Problem125 problem125 = new Problem125();
        String p = "3\n" +
                "1 9\n" +
                "7 17\n" +
                "23 23";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem125.solution();
    }
}