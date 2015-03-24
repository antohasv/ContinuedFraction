package algorithm;

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

        List<Integer> resultFractions = ContinuousFractionAlg.initArg(a, b).solve();
        ConvergentsAlg.Convergents convergents = ConvergentsAlg.initArg(resultFractions).solve();

        System.out.println("ContinuousFraction{Q_s=" + resultFractions.toString() + "}");
        System.out.println(convergents.toString());
    }
}
