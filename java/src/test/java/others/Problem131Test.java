package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem131Test {
    @Test
    void solution() throws IOException {
        Problem131 problem131 = new Problem131();
        String p = "2\n" +
                "3\n" +
                "1 3 2\n" +
                "5\n" +
                "1 3 5 4 2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem131.solution();
    }
}