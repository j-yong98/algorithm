package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem56Test {

    @Test
    void solution() throws IOException {
        Problem56 problem56 = new Problem56();
        String p = "7";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem56.solution();
    }

}