package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import others.Problem2;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class Problem2Test {

    @ParameterizedTest
    @MethodSource("init")
    void Solution(String problem, int answer) throws IOException {
        Problem2 problem2 = new Problem2();
        System.setIn(new ByteArrayInputStream(problem.getBytes()));

        int ans = problem2.problem2();

        Assertions.assertThat(ans).isEqualTo(answer);
    }

    static Stream<Arguments> init(){
        return Stream.of(
                arguments("3 2\n" +
                        "1 2 2\n" +
                        "1 3 4\n" +
                        "1 2 3\n",2),
                arguments("3 1\n" +
                        "1 2 3\n" +
                        "4 5 6\n" +
                        "7 8 8\n",6)
        );
    }
}