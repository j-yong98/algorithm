package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem97Test {
    @Test
    void solution() throws IOException {
        Problem97 problem97 = new Problem97();
        String p = "3 5\n" +
                "1 3 39\n" +
                "1 4 20\n" +
                "4 5 25\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem97.solution();
    }

}