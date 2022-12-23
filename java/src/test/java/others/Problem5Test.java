package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import others.Problem5;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.stream.Stream;

class Problem5Test {

    @ParameterizedTest
    @MethodSource("problem")
    void solution(String problem, int[] answer) throws IOException {
        Problem5 problem5 = new Problem5();
        System.setIn(new ByteArrayInputStream(problem.getBytes()));
        int[] solution = problem5.solution();

        Assertions.assertThat(solution).isEqualTo(answer);
    }

    static Stream<Arguments> problem(){
        return Stream.of(
                Arguments.arguments("3 1\n" +
                        "1 2 3\n" +
                        "6 5 1\n",new int[]{1,1,2,3,6,5}),
                Arguments.arguments("3 3\n" +
                        "1 2 3\n" +
                        "6 5 1\n", new int[]{6,5,1,1,2,3})
        );
    }
}