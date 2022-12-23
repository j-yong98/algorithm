package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class Problem25Test {
    Problem25 problem25;

    @BeforeEach
    void init(){
        problem25 = new Problem25();
    }

    @Test
    @DisplayName("반시계방향 회전")
    void rotateTest(){
        int[][] arr = new int[][]{{0,1,2,3},{4,5,6,7},{8,9,10,11},{12,13,14,15}};

        int[][] rotate = problem25.rotate(4, arr);

        Assertions.assertThat(rotate).isEqualTo(new int[][]{
                {3,7,11,15},
                {2,6,10,14},
                {1,5,9,13},
                {0,4,8,12}
        });
    }

    @ParameterizedTest
    @MethodSource("problem")
    void solution(String p, int ans) throws IOException {
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem25.solution();

        Assertions.assertThat(solution).isEqualTo(ans);
    }

    static Stream<Arguments> problem(){
        return Stream.of(
                arguments("3\n" +
                        "1 1\n" +
                        ".#.\n" +
                        "#..\n" +
                        "...\n",1),
                arguments("3\n" +
                        "1 1\n" +
                        "...\n" +
                        "##.\n" +
                        "...\n",7),
                arguments("3\n" +
                        "1 1\n" +
                        "...\n" +
                        "#..\n" +
                        "...\n",5),
                arguments("3\n" +
                        "1 2\n" +
                        "...\n" +
                        ".#.\n" +
                        "...\n",-1),
                arguments("6\n" +
                        "3 3\n" +
                        "######\n" +
                        "#....#\n" +
                        "##...#\n" +
                        "#.##.#\n" +
                        "#....#\n" +
                        "######",-1)
        );
    }
}