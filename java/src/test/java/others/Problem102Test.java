package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem102Test {
    @Test
    void solution() throws IOException {
        Problem102 problem102 = new Problem102();
        String p = "5\n" +
                "1 3\n" +
                "2 5\n" +
                "-1 6\n" +
                "2 4\n" +
                "-1 9\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem102.solution();
    }
}