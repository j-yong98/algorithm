package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem137Test {
    @Test
    void solution() throws IOException {
        Problem137 problem137 = new Problem137();
        String p = "7\n" +
                "0 1\n" +
                "1 9\n" +
                "8 23\n" +
                "2 3\n" +
                "3 4\n" +
                "7 8\n" +
                "4 6\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem137.solution();
    }
}