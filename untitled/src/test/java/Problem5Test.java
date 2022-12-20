import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem5Test {

    @Test
    void solution() throws IOException {
        Problem5 problem5 = new Problem5();
        String p = "3 1\n" +
                "1 2 3\n" +
                "6 5 1\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem5.solution();
    }

}