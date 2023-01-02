package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem64Test {

    @Test
    void solution() throws IOException {
        Problem64 problem64 = new Problem64();
        String p = "3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem64.solution();
    }

}