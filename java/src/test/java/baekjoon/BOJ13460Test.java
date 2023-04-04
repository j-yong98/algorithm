package baekjoon;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class BOJ13460Test {
    @ParameterizedTest
    @MethodSource("testCase")
    void solution(String p, int ans) throws IOException {
        BOJ13460 boj13460 = new BOJ13460();
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = boj13460.solution();
        Assertions.assertThat(solution).isEqualTo(ans);
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                arguments("7 5\n" +
                        "#####\n" +
                        "###.#\n" +
                        "##.O#\n" +
                        "#R..#\n" +
                        "#####\n" +
                        "###B#\n" +
                        "#####", 2),
                arguments("5 10\n" +
                        "##########\n" +
                        "#.#......#\n" +
                        "##.......#\n" +
                        "#OR..B.#.#\n" +
                        "##########", 7),
                arguments("4 7\n" +
                        "#######\n" +
                        "##R...#\n" +
                        "#O.#.B#\n" +
                        "#######", 2),
                arguments("7 4\n" +
                        "####\n" +
                        "#B##\n" +
                        "####\n" +
                        "#.##\n" +
                        "#R##\n" +
                        "#O##\n" +
                        "####", 1),
                arguments("10 5\n" +
                        "#####\n" +
                        "#..##\n" +
                        "#.O##\n" +
                        "#...#\n" +
                        "#.R##\n" +
                        "##.##\n" +
                        "##.##\n" +
                        "#.###\n" +
                        "#.B.#\n" +
                        "#####", 1)
        );
    }
}