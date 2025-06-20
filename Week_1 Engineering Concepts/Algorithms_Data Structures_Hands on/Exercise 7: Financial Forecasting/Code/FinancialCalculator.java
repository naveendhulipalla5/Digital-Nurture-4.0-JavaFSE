public class FinancialCalculator {
    
    public static double calculateFutureValue(double currentValue, double growthRate, int periods) {
        if (periods == 0) {
            return currentValue;
        }
        double nextValue = currentValue * (1 + growthRate);
        return calculateFutureValue(nextValue, growthRate, periods - 1);
    }
    
    public static double calculateAverageGrowthRate(double[] pastValues) {
        if (pastValues == null || pastValues.length < 2) {
            throw new IllegalArgumentException("Need at least 2 past values");
        }
        
        double totalGrowth = 0;
        for (int i = 1; i < pastValues.length; i++) {
            totalGrowth += (pastValues[i] - pastValues[i-1]) / pastValues[i-1];
        }
        return totalGrowth / (pastValues.length - 1);
    }
}