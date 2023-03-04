package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem103Test {
    @Test
    void solution() throws IOException {
        Problem103 problem103 = new Problem103();
        String p = "5\n" +
                "1 5 2 2 1\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem103.solution();
    }
}