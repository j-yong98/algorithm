package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class Problem22Test {

    @Test
    void solution(){
        String p = "5\n" +
                "2 3 5 7 11\n";
        Problem22 problem22 = new Problem22();
        System.setIn(new ByteArrayInputStream(p.getBytes()));

        int solution = problem22.solution();

        Assertions.assertThat(solution).isEqualTo(1);
    }

}