package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem58Test {

    @Test
    void solution() throws IOException {
        Problem58 problem58 = new Problem58();
        String p = "5\n" +
                "2 1 1 0 4\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem58.solution();
    }

}