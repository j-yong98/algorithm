package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem105Test {
    @Test
    void solution() throws IOException {
        Problem105 problem105 = new Problem105();
        String p = "3 8\n" +
                "AATCCCAT\n" +
                "GATTGCAA\n" +
                "GGTCGCAA\n" +
                "ACTCCCAG\n" +
                "ACTCGCAT\n" +
                "ACTTCCAT\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem105.solution();
    }
}