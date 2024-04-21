import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1(){
        int n = 6;
        int[][] edges = {
                {0,1},
                {0,2},
                {1,3},
                {3,4},
                {4,5}
        };
        String labels = "cbabaa";
        int[] expected = {1,2,1,1,2,1};
        int[] actual = new Solution().countSubTrees(n, edges, labels);

        Assert.assertArrayEquals(expected, actual);

    }
    @Test
    public void test2(){
        int n = 7;
        int[][] edges = {
                {0,1},
                {1,2},
                {2,3},
                {3,4},
                {4,5},
                {5, 6}
        };
        String labels = "aaabaaa";
        int[] expected = {6,5,4,1,3,2,1};
        int[] actual = new Solution().countSubTrees(n, edges, labels);

        Assert.assertArrayEquals(expected, actual);

    }
}
