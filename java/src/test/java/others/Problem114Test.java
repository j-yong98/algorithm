package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem114Test {
    @Test
    void solution() throws IOException {
        Problem114 problem114 = new Problem114();
        String p = "5\n" +
                "2\n" +
                "3\n" +
                "10\n" +
                "50\n" +
                "100";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem114.solution();
    }
}