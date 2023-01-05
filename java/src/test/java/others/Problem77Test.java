package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem77Test {

    @Test
    void solution() throws IOException {
        Problem77 problem77 = new Problem77();
        String p = "3\n" +
                "5 6 7\n" +
                "6 5 4\n" +
                "5 7 1\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem77.solution();
    }

}