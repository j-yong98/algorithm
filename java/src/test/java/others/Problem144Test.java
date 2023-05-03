package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem144Test {
    @Test
    void solution() throws IOException {
        Problem144 problem144 = new Problem144();
        String p = "6\n" +
                "xxyyzz\n" +
                "yc\n" +
                "aaaab\n" +
                "bca\n" +
                "ppzqq\n" +
                "qnwerrewmq";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem144.solution();
    }
}