package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem130Test {
    @Test
    void solution() throws IOException {
        Problem130 problem130 = new Problem130();
        String p = "5\n" +
                "ABAB\n" +
                "CCDD\n" +
                "EFFE\n" +
                "EEEE\n" +
                "NONE";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem130.solution();
    }
}