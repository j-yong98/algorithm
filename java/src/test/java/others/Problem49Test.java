package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem49Test {

    @Test
    void solution() throws IOException {
        Problem49 problem49 = new Problem49();
        String p = "4\n" +
                "0 0 0 0\n" +
                "0 0 1 0\n" +
                "0 1 0 0\n" +
                "0 0 0 0\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem49.solution();
    }

}