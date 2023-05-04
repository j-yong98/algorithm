package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem146Test {
    @Test
    void solution() throws IOException {
        Problem146 problem146 = new Problem146();
        String p = "2\n" +
                "4\n" +
                "3 4 1 2\n" +
                "5\n" +
                "2 3 4 4 5";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem146.solution();
    }
}