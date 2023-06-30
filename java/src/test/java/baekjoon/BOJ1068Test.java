package baekjoon;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class BOJ1068Test {
    @ParameterizedTest
    @MethodSource("testCase")
    void solution(String p, int ans) throws IOException {
        BOJ1068 boj1068 = new BOJ1068();
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = boj1068.solution();
        Assertions.assertThat(solution).isEqualTo(ans);
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                arguments("5\n" +
                        "-1 0 0 1 1\n" +
                        "2", 2),
                arguments("5\n" +
                        "-1 0 0 1 1\n" +
                        "1", 1),
                arguments("5\n" +
                        "-1 0 0 1 1\n" +
                        "0", 0),
                arguments("9\n" +
                        "-1 0 0 2 2 4 4 6 6\n" +
                        "4", 2),
                arguments("3\n" +
                        "-1 0 1\n" +
                        "2", 1)
        );
    }
}