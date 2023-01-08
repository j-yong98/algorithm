package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem91Test {

    @Test
    void solution() throws IOException {
        Problem91 problem91 = new Problem91();
        String p = "4\n" +
                "2 9 10 11\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem91.solution();
    }

}