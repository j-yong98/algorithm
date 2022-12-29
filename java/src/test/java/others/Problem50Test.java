package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem50Test {

    @Test
    void solution() throws IOException {
        Problem50 problem50 = new Problem50();
        String p = "4 5\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem50.solution();
    }

}