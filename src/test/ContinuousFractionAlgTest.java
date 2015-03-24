package test;

import algorithm.ContinuousFractionAlg;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ContinuousFractionAlgTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test(expected=IllegalArgumentException.class)
    public void testBoundary() {
        ContinuousFractionAlg.initArg(100, 0).solve();
    }

    @Test
    public void testAlgCorrect() throws Exception {
        List<Integer> resultFractions = ContinuousFractionAlg.initArg(9, 4).solve();
        Assert.assertTrue(resultFractions.size() == 2);
        Assert.assertArrayEquals(resultFractions.toArray(), new Integer[] {2, 4});
    }

    @Test
    public void testNegativeValue() throws Exception {
        List<Integer> resultFractions = ContinuousFractionAlg.initArg(-9, 4).solve();
        Assert.assertTrue(resultFractions.size() == 2);
        Assert.assertArrayEquals(resultFractions.toArray(), new Integer[] {-2, -4});
    }
}