package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem99Test {
    @Test
    void solution() throws IOException {
        Problem99 problem99 = new Problem99();
        String p = "5 4\n" +
                "1 2 1 4 -1\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem99.solution();
    }
}