import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class Problem10Test {
    Problem10 problem10;
    OutputStream outputStream;

    @BeforeEach
    void init(){
        problem10 = new Problem10();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void shiftLeftTest(){
        int[][] arr = new int[][]{{1,2,3},{4,3,2}};

        int[][] res = problem10.shiftLeft(arr,2,3, 0);

        Assertions.assertThat(res).isEqualTo(new int[][]{{2,3,1},{4,3,2}});
    }

    @Test
    void shiftRightTest(){
        int[][] arr = new int[][]{{1,2,3},{4,3,2}};

        int[][] res = problem10.shiftRight(arr,2,3, 1);

        Assertions.assertThat(res).isEqualTo(new int[][]{{1,2,3},{2,4,3}});
    }

    @Test
    void solution() throws IOException {
        String p = "3 3 2\n" +
                "1 2 3\n" +
                "3 2 1\n" +
                "3 3 3\n" +
                "3 L\n" +
                "1 L\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem10.solution();
        Assertions.assertThat(outputStream.toString().trim()).isEqualTo(
                "2 3 1 \n" +
                "1 3 2 \n" +
                "3 3 3");
    }
}