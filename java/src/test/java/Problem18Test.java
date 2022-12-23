import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.util.stream.Stream;

class Problem18Test {

    @ParameterizedTest
    @MethodSource("problem")
    void solution(String p, String answer) throws IOException {
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Problem18 problem18 = new Problem18();
        problem18.solution();
        Assertions.assertThat(outputStream.toString().trim()).isEqualTo(answer);
    }

    static Stream<Arguments> problem() {
        return Stream.of(
                Arguments.arguments("4 3\n" +
                                "1 2 4 3\n" +
                                "3 2 2 3\n" +
                                "3 1 6 2\n" +
                                "4 5 4 4\n" +
                                "2\n" +
                                "2\n" +
                                "2\n",
                                "0 0 0 0 \n" +
                                "0 0 0 3 \n" +
                                "3 0 2 3 \n" +
                                "3 0 6 2"),
                Arguments.arguments("4 4\n" +
                                "1 1 2 3\n" +
                                "3 2 2 3\n" +
                                "3 1 6 2\n" +
                                "4 5 4 4\n" +
                                "2\n" +
                                "2\n" +
                                "2\n" +
                                "2\n",
                                "0 0 0 0 \n" +
                                "0 0 0 3 \n" +
                                "1 0 2 3 \n" +
                                "3 0 6 2")
        );
    }
}