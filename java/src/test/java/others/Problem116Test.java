package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem116Test {
    @Test
    void solution() throws IOException {
        Problem116 problem116 = new Problem116();
        String p = "3\n" +
                "3 6\n" +
                "#.????\n" +
                "?#????\n" +
                "???.??\n" +
                "1 6\n" +
                "##????\n" +
                "3 3\n" +
                ".#.\n" +
                "#?#\n" +
                ".#.";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem116.solution();
    }
}