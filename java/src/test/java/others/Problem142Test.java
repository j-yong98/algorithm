package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem142Test {
    @Test
    void solution() throws IOException {
        Problem142 problem142 = new Problem142();
        String p = "3\n" +
                "1\n" +
                "6\n" +
                "4\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem142.solution();
    }
}