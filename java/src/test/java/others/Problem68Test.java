package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem68Test {

    @Test
    void solution() throws IOException {
        Problem68 problem68 = new Problem68();
        String p = "7";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem68.solution();
    }

}