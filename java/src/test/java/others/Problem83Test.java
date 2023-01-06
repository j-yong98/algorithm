package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem83Test {

    @Test
    void solution() throws IOException {
        Problem83 problem83 = new Problem83();
        String p = "3\n" +
                "1 2 10\n" +
                "2 3 26\n" +
                "3 3 15\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem83.solution();
    }

}