package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem106Test {
    @Test
    void solution() throws IOException {
        Problem106 problem106 = new Problem106();
        String p = "3\n" +
                "3 17 1 39 8 41 2 32 99 2\n" +
                "22 8 5 123 7 2 63 7 3 46\n" +
                "6 63 2 3 58 76 21 33 8 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem106.solution();
    }
}