package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem115Test {
    @Test
    void solution() throws IOException {
        Problem115 problem115 = new Problem115();
        String p = "3\n" +
                "||||||\n" +
                "(|..|)\n" +
                ".|.(|...||)|...()..";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem115.solution();
    }
}