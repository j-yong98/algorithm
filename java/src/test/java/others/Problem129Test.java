package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem129Test {
    @Test
    void solution() throws IOException {
        Problem129 problem129 = new Problem129();
        String p = "2\n" +
                "-2 -1\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem129.solution();
    }
}