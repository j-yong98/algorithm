package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Problem23Test {

    @Test
    void solution() throws IOException {
        String p = "4 1 1\n" +
                "1 2 2 3\n" +
                "3 5 10 15\n" +
                "3 8 11 2\n" +
                "4 5 4 4\n";
        Problem23 problem23 = new Problem23();
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        problem23.solution();

        assertThat(outputStream.toString().trim()).isEqualTo("1 3 5 8 11");
    }

}