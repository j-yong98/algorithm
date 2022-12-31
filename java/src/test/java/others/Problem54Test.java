package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem54Test {

    @Test
    void solution() throws IOException {
        Problem54 problem54 = new Problem54();
        String p = "a+e\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem54.solution();
    }

}