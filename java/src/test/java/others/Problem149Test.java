package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem149Test {
    @Test
    void solution() throws IOException {
        Problem149 problem149 = new Problem149();
        String p = "3\n" +
                "4 B 2 O 1 O 2 B 4\n" +
                "3 B 5 B 8 O 100\n" +
                "2 O 2 O 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem149.solution();
    }
}