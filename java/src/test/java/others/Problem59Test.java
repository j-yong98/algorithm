package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class Problem59Test {
    OutputStream outputStream;
    @BeforeEach
    void init(){
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }
    @Test
    void solution() throws IOException {
        Problem59 problem59 = new Problem59();
        String p = "4 3\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem59.solution();
        Assertions.assertThat(outputStream.toString().trim()).isEqualTo(
                "1 2 3 \n" +
                "1 2 4 \n" +
                "1 3 4 \n" +
                "2 3 4");
    }

}