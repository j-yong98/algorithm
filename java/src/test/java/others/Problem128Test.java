package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem128Test {
    @Test
    void solution() throws IOException {
        Problem128 problem128 = new Problem128();
        String p = "5 3800\n" +
                "1\n" +
                "5\n" +
                "100\n" +
                "500\n" +
                "1000\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem128.solution();
    }
}