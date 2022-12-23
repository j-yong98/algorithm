package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem24Test {
    @Test
    void solution() throws IOException {
        String p = "4 2 2\n" +
                "0 0 0 0\n" +
                "0 0 0 1\n" +
                "1 0 0 1\n" +
                "1 1 1 1\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        Problem24 problem24 = new Problem24();
        problem24.solution();
    }
}