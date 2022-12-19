import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class problem1Test {

    @ParameterizedTest
    @MethodSource("condition")
    void exhaustiveTest(String problem,int answer) throws IOException {
        Problem1 Problem1 = new Problem1();
        System.setIn(new ByteArrayInputStream(problem.getBytes()));


        int ans = Problem1.exhaustive();

        Assertions.assertThat(ans).isEqualTo(answer);
    }

    static Stream<Arguments> condition() {
        return Stream.of(
                arguments("3\n" +
                        "1 0 1\n" +
                        "0 1 0\n" +
                        "0 1 0", 4),
                arguments("5\n" +
                        "0 0 0 1 1\n" +
                        "1 0 1 1 1\n" +
                        "0 1 0 1 0\n" +
                        "0 1 0 1 0\n" +
                        "0 0 0 1 1\n", 6)
        );
    }
}