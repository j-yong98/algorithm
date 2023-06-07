package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem159Test {
    @Test
    void solution() throws IOException {
        Problem159 problem159 = new Problem159();
        String p = "2\n" +
                "-2 -1\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem159.solution();
    }
}