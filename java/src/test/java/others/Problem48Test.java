package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem48Test {

    @Test
    void solution() throws IOException {
        Problem48 problem48 = new Problem48();
        String p = "2\n" +
                "2\n" +
                "-1 -1 1 D\n" +
                "-1 0 1 U\n" +
                "3\n" +
                "1 0 3 U\n" +
                "0 1 3 R\n" +
                "2 -1 3 U\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem48.solution();
    }

}