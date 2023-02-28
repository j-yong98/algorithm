package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem100Test {

    @Test
    void solution() throws IOException {
        Problem100 problem100 = new Problem100();
        String p = "5 2\n" +
                "1 1 3 2 3\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem100.solution();
    }

}