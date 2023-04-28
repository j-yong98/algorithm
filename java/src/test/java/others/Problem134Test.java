package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem134Test {
    @Test
    void solution() throws IOException {
        Problem134 problem134 = new Problem134();
        String p = "5 8\n" +
                "2 3\n" +
                "6 5\n" +
                "2 4\n" +
                "3 2\n" +
                "4 3\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem134.solution();
    }
}