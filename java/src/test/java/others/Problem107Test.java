package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem107Test {
    @Test
    void solution() throws IOException {
        Problem107 problem107 = new Problem107();
        String p = "3\n" +
                "10\n" +
                "50\n" +
                "10000000019";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem107.solution();
    }
}