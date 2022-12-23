import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class Problem8Test {

    @Test
    void solution() throws IOException {
        Problem8 problem8 = new Problem8();
        String p = "3 3\n" +
                "1 2 4\n" +
                "5 9 3\n" +
                "6 5 1\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        problem8.solution();
        Assertions.assertThat(outputStream.toString().trim()).isEqualTo("6 5 1 \n1 2 4 \n5 9 3");
    }
}