package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem170Test {
    @Test
    void solution() throws IOException {
        Problem170 problem170 = new Problem170();
        String p = "2\n" +
                "5 0 1 1 0 0 1 0 1 1 1 1 1 0 0 0 0 1 0 0 0 0 1 0 0 0\n" +
                "5 0 0 1 1 0 0 0 1 0 0 1 1 0 0 1 1 0 0 0 1 0 0 1 1 0";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem170.solution();
    }
}