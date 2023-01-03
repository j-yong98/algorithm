package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem66Test {

    @Test
    void solution() throws IOException {
        Problem66 problem66 = new Problem66();
        String p = "4\n" +
                "0 2 5 9\n" +
                "3 0 8 11\n" +
                "7 3 0 10\n" +
                "9 5 7 0\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem66.solution();
    }

}