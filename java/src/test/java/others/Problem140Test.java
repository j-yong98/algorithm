package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem140Test {
    @Test
    void solution() throws IOException {
        Problem140 problem140 = new Problem140();
        String p = "40674\n\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem140.solution();
    }
}