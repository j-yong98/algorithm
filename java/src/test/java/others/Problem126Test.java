package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem126Test {
    @Test
    void solution() throws IOException {
        Problem126 problem126 = new Problem126();
        String p = "3\n" +
                "KOREAKOREAKOREAKOREAKOREAKOREA\n" +
                "SAMSUNGSAMSUNGSAMSUNGSAMSUNGSA\n" +
                "GALAXYGALAXYGALAXYGALAXYGALAXY";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem126.solution();
    }
}