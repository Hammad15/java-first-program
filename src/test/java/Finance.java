import com.h2.BestLoanRates;
import com.h2.MortgageCalculator;
import com.h2.SavingsCalculator;

import java.beans.beancontext.BeanContext;
import java.util.Arrays;
import java.util.Map;

public class Finance {

    public final static String BEST_LOAN_RATES = "bestLoanRates";
    public final static String SAVINGS_CALCULATOR = "savingsCalculator";
    public final static String MORTGAGE_CALCULATOR = "mortgageCalculator";

    public final static Map<String, String> commandsToUsage
            = Map.of(BEST_LOAN_RATES, "usage: bestLoanRates",
            SAVINGS_CALCULATOR, "usage: savingsCalculator <credits separated by ','> <debits separated by ','>",
            MORTGAGE_CALCULATOR, "usage: MortgageCalculator <loanAmount> <termInYears> <annualRate>");

    public static void main(String[] args) {
        String command = args[0];
        if (!commandsToUsage.containsKey(command)) {
            System.out.println(command + ": command not found");
            return;
        }

        boolean isValidCommand = validateCommandArguments(args);

        if (!isValidCommand) {
            commandsToUsage.get(command);
            return;
        }

        executeCommand(command, Arrays.copyOfRange(args, 1, args.length));
    }

    private static boolean validateCommandArguments(String[] args) {

        switch (args[0]) {
            case BEST_LOAN_RATES:
                return args.length == 1;
            case SAVINGS_CALCULATOR:
                return  args.length == 3;
            case MORTGAGE_CALCULATOR:
                return  args.length == 4;
        }
        return false;
    }

    private static void executeCommand(String command, String[] args) {

        switch (command) {
            case BEST_LOAN_RATES:
                System.out.println("Finding best loan rates ...");
                BestLoanRates.main(args);
                return;
            case SAVINGS_CALCULATOR:
                System.out.println("Finding your net savings ...");
                SavingsCalculator.main(args);
                return;
            case MORTGAGE_CALCULATOR:
                System.out.println("Finding your monthly payment ...");
                MortgageCalculator.main(args);
                return;
        }
    }
}
