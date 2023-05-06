package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem148Test {
    @Test
    void solution() throws IOException {
        Problem148 problem148 = new Problem148();
        String p = "2\n" +
                "3\n" +
                "3 2 7 5 6 1 4\n" +
                "2\n" +
                "2 1 3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem148.solution();
    }
}