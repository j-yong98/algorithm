package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem138Test {
    @Test
    void solution() throws IOException {
        Problem138 problem138 = new Problem138();
        String p = "3\n" +
                "43\n" +
                "37\n" +
                "4\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem138.solution();
    }
}