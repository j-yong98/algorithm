package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem62Test {

    @Test
    void solution() throws IOException {
        Problem62 problem62 = new Problem62();
        String p = "3\n" +
                "1 8 9 3 5 15\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem62.solution();
    }

}