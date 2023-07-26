package baekjoon;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class BOJ1417Test {
    @ParameterizedTest
    @MethodSource("testCase")
    void solution(String p, int ans) throws IOException {
        BOJ1417 boj1417 = new BOJ1417();
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = boj1417.solution();
        Assertions.assertThat(solution).isEqualTo(ans);
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(arguments("3\n" +
                "5\n" +
                "7\n" +
                "7", 2),
                arguments("4\n" +
                        "10\n" +
                        "10\n" +
                        "10\n" +
                        "10", 1),
                arguments("1\n" +
                        "1", 0),
                arguments("5\n" +
                        "5\n" +
                        "10\n" +
                        "7\n" +
                        "3\n" +
                        "8", 4)
                );
    }
}