import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem21Test {

    @Test
    void solutiion() throws IOException {
        Problem21 problem21 = new Problem21();
        String p = "5\n" +
                "1 3 5 8 10\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem21.solution();
        Assertions.assertThat(solution).isEqualTo(3);
    }
}