package baekjoon;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class BOJ17140Test {
    @Test
    void makeNewArrayTest() {
        BOJ17140 boj17140 = new BOJ17140();
        int[] tmp = boj17140.makeNewArray(new int[]{3, 1, 1, 2});
        Arrays.stream(tmp).forEach(System.out::println);
        Assertions.assertThat(tmp).isEqualTo(new int[]{2, 1, 3, 1, 1, 2});
    }

    @ParameterizedTest
    @MethodSource("testCase")
    void solution(String p, int ans) throws IOException {
        BOJ17140 boj17140 = new BOJ17140();
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = boj17140.solution();
        Assertions.assertThat(solution).isEqualTo(ans);
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(arguments("1 2 2\n" +
                "1 2 1\n" +
                "2 1 3\n" +
                "3 3 3", 0),
                arguments("1 2 1\n" +
                        "1 2 1\n" +
                        "2 1 3\n" +
                        "3 3 3", 1),
                arguments("1 2 3\n" +
                        "1 2 1\n" +
                        "2 1 3\n" +
                        "3 3 3", 2),
                arguments("1 2 4\n" +
                        "1 2 1\n" +
                        "2 1 3\n" +
                        "3 3 3", 52),
                arguments("1 2 5\n" +
                        "1 2 1\n" +
                        "2 1 3\n" +
                        "3 3 3", -1),
                arguments("3 3 3\n" +
                        "1 1 1\n" +
                        "1 1 1\n" +
                        "1 1 1", 2),
                arguments("28 13 13\n" +
                        "1 2 1\n" +
                        "2 1 3\n" +
                        "3 3 3", 100)
        );
    }
}