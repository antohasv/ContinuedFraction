import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public Main() {
    }

    public static void main(String []args) {
        new Main().execute();
    }

    public void execute() {
        int a = 105;
        int b = 38;

        List<Integer> resultFractions = computeContinuousFraction(a, b);
        Convergents convergents = computeConvergents(resultFractions);
        System.out.println("ContinuousFraction{Q_s=" + resultFractions.toString() + "}");
        System.out.println(convergents.toString());
    }

    private List<Integer> computeContinuousFraction(int a, int b) {
        List<Integer> resultFractions = new ArrayList<Integer>();
        int d = 0;
        do {
            resultFractions.add(a / b);
            d = a % b;
            a = b;
            b = d;
         } while (d != 0);
        return resultFractions;
    }

    private Convergents computeConvergents(List<Integer> resultFractions) {
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

    class Convergents {
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
