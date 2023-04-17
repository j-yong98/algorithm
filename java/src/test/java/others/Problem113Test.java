package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem113Test {
    @Test
    void solution() throws IOException {
        Problem113 problem113 = new Problem113();
        String p = "5\n" +
                "abcdefghijklmnopqrstu\n" +
                "abcdefghijklmnopqrstuvwzyx\n" +
                "abcefghijk\n" +
                "xyz\n" +
                "absolute";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem113.solution();
    }
}