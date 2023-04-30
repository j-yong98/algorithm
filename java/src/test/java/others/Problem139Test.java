package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem139Test {
    @Test
    void solution() throws IOException {
        Problem139 problem139 = new Problem139();
        String p = "1\n" +
                "5\n" +
                "2 5 14\n" +
                "2 3 2\n" +
                "3 2 7\n" +
                "1 1 2\n" +
                "2 1 3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem139.solution();
    }
}