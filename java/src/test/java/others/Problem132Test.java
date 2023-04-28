package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem132Test {
    @Test
    void solution() throws IOException {
        Problem132 problem132 = new Problem132();
        String p = "3\n" +
                "1\n" +
                "10\n" +
                "100";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem132.solution();
    }
}