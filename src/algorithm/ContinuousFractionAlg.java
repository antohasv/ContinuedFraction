package algorithm;

import java.util.ArrayList;
import java.util.List;

public class ContinuousFractionAlg {

    private int mA;
    private int mB;

    private boolean mIsSignPositive = true;

    public static ContinuousFractionAlg initArg(int a, int b) {
        return new ContinuousFractionAlg(a, b);
    }

    public ContinuousFractionAlg(int mA, int mB) {
        if (mB == 0) {
            throw new IllegalArgumentException("denominator == 0");
        }
        this.mIsSignPositive = (mA > 0 & mB > 0) || (mA < 0 && mB < 0);
        this.mA = Math.abs(mA);
        this.mB = Math.abs(mB);
    }

    public List<Integer> solve() {
        List<Integer> resultFractions = new ArrayList<Integer>();
        if (mA == 0 || mA < mB) {
            return resultFractions;
        }

        int d = 0;
        do {
            resultFractions.add((mIsSignPositive ? 1 : -1) * (mA / mB));
            d = mA % mB;
            mA = mB;
            mB = d;
        } while (d != 0);
        return resultFractions;
    }
}
