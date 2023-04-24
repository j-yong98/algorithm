package baekjoon;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class BOJ1459Test {
    @ParameterizedTest
    @MethodSource("testCase")
    void solution(String p, long ans) throws IOException {
        BOJ1459 boj1459 = new BOJ1459();
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        long solution = boj1459.solution();
        Assertions.assertThat(solution).isEqualTo(ans);
    }
    private static Stream<Arguments> testCase() {
        return Stream.of(
                arguments("4 2 3 10", 18),
                arguments("4 2 3 5", 16),
                arguments("2 0 12 10", 20),
                arguments("25 18 7 11", 247),
                arguments("24 16 12 10", 240),
                arguments("10000000 50000000 800 901", 41010000000L),
                arguments("135 122 43 29", 3929)

        );
    }
}