package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem135Test {
    @Test
    void solution() throws IOException {
        Problem135 problem135 = new Problem135();
        String p = "3\n" +
                "50 50 50\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem135.solution();
    }
}