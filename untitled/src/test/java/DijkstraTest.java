import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraTest {


    @Test
    void dijkstraTest(){
        int[][] arr = new int[][]{
                {1, 2 ,2},
                {1 ,3 ,5},
                {1 ,4, 1},
                {2 ,3 ,3},
                {2 ,4, 2},
                {3 ,2, 3},
                {3 ,6, 5},
                {4 ,3, 3},
                {4 ,5, 1},
                {5 ,3, 1},
                {5 ,6, 2},
        };
        Dijkstra dijkstra = new Dijkstra();
        int[] res = dijkstra.dijkstra(6, arr, 1);

        Assertions.assertThat(res).isEqualTo(new int[]{0,0,2,3,1,2,4});
    }

}