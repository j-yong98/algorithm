package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem44Test {

    @Test
    void solution() throws IOException {
        Problem44 problem44 = new Problem44();
        String p = "4 2\n" +
                "15 13 1 11\n" +
                "4 8 3 5\n" +
                "2 12 16 7\n" +
                "14 6 9 10\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem44.solution();
    }

}