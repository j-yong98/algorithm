package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem120Test {
    @Test
    void solution() throws IOException {
        Problem120 problem120 = new Problem120();
        String p = "3\n" +
                "oxoxoxoxoxoxoxo\n" +
                "x\n" +
                "xxxxxxxxxxxx";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem120.solution();
    }
}