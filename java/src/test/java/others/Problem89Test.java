package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem89Test {

    @Test
    void solution() throws IOException {
        Problem89 problem89 = new Problem89();
        String p = "5 12\n" +
                "5 2 4 9 1\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem89.solution();
    }

}