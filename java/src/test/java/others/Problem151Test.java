package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem151Test {
    @Test
    void solution() throws IOException {
        Problem151 problem151 = new Problem151();
        String p = "2\n" +
                "3 4\n" +
                "2\n" +
                "3\n" +
                "5\n" +
                "2\n" +
                "1\n" +
                "3\n" +
                "8\n" +
                "3\n" +
                "2\n" +
                "-3\n" +
                "1\n" +
                "4\n" +
                "-4\n" +
                "-2\n" +
                "-1\n" +
                "2 4\n" +
                "5\n" +
                "2\n" +
                "100\n" +
                "500\n" +
                "1000\n" +
                "2000\n" +
                "3\n" +
                "1\n" +
                "2\n" +
                "4\n" +
                "-1\n" +
                "-3\n" +
                "-2\n" +
                "-4";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem151.solution();
    }
}