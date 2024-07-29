import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class FinancialForcasting {
    private static Map<Integer, Double> memo = new HashMap<>();
    public static double calculateFutureValue(double initialValue, double growthRate, int periods)
    {
        if (periods == 0)
            return initialValue;
        if (memo.containsKey(periods))
            return memo.get(periods);
        double futureValue = calculateFutureValue(initialValue, growthRate, periods - 1) * (1 + growthRate);
        memo.put(periods, futureValue);
        return futureValue;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter current or initial value: ");
        double initialValue =sc.nextDouble();
        System.out.print("Enter growth rate: ");
        double growthRate=sc.nextDouble();
        System.out.println("Enter time in years: ");
        int periods=sc.nextInt();
        double futureValue=calculateFutureValue(initialValue,growthRate,periods);
        System.out.println("Future Value: " + futureValue);
    }
}