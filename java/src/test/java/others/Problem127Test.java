package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem127Test {
    @Test
    void solution() throws IOException {
        Problem127 problem127 = new Problem127();
        String p = "3\n" +
                "100 1 50\n" +
                "1000 81 83\n" +
                "10 10 100";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem127.solution();
    }
}