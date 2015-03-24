package algorithm;

import java.util.Arrays;
import java.util.List;

public class ConvergentsAlg {

    private List<Integer> resultFractions;

    public static ConvergentsAlg initArg(List<Integer> resultFractions) {
        return new ConvergentsAlg(resultFractions);
    }

    public ConvergentsAlg(List<Integer> resultFractions) {
        if (resultFractions == null) {
            throw new IllegalArgumentException("resultFractions == null");
        }

        if (resultFractions.size() == 0) {
            throw new IllegalArgumentException("resultFractions size = 0");
        }
        this.resultFractions = resultFractions;
    }

    public Convergents solve() {
        if (resultFractions.size() == 0) {
            return null;
        }

        Integer[] arrayP = new Integer[resultFractions.size() + 1];
        Integer[] arrayQ = new Integer[resultFractions.size() + 1];

        arrayP[0] = 1;
        arrayQ[0] = 0;

        arrayP[1] = resultFractions.get(0);
        arrayQ[1] = 1;

        for (int i = 1; i < resultFractions.size(); i++) {
            arrayP[i + 1] = resultFractions.get(i) * arrayP[i] + arrayP[i - 1];
            arrayQ[i + 1] = resultFractions.get(i) * arrayQ[i] + arrayQ[i - 1];
        }

        return new Convergents(arrayP, arrayQ);
    }

    public class Convergents {
        Integer[] arrayP;
        Integer[] arrayQ;

        public Convergents(Integer[] arrayP, Integer[] arrayQ) {
            this.arrayP = arrayP;
            this.arrayQ = arrayQ;
        }

        public Integer[] getArrayP() {
            return arrayP;
        }

        public Integer[] getArrayQ() {
            return arrayQ;
        }

        @Override
        public String toString() {
            return "Convergents{" + "\n" +
                    "P_s=" + Arrays.toString(arrayP) + "\n" +
                    "Q_s=" + Arrays.toString(arrayQ) +
                    '}';
        }
    }
}
