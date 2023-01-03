package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem67Test {

    @Test
    void solution() throws IOException {
        Problem67 problem67 = new Problem67();
        String p = "3\n" +
                "3 5 3\n" +
                "5 8 4\n" +
                "2 7 1\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem67.solution();
    }

}