package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem147Test {
    @Test
    void solution() throws IOException {
        Problem147 problem147 = new Problem147();
        String p = "3\n" +
                "1 8\n" +
                "2 5\n" +
                "1 2\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem147.solution();
    }
}