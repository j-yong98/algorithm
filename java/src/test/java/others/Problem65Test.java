package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem65Test {

    @Test
    void solution() throws IOException {
        Problem65 problem65 = new Problem65();
        String p = "3\n" +
                "3 5 3\n" +
                "5 8 4\n" +
                "2 7 1\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem65.solution();
    }

}