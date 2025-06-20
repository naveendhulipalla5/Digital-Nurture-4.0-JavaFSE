public class FinancialForecaster {
    
    private final double[] pastValues;
    private final double growthRate;
    
    public FinancialForecaster(double[] pastValues) {
        this.pastValues = pastValues.clone();
        this.growthRate = FinancialCalculator.calculateAverageGrowthRate(pastValues);
    }
    
    public double[] predict(int futurePeriods) {
        double[] result = new double[pastValues.length + futurePeriods];
        System.arraycopy(pastValues, 0, result, 0, pastValues.length);
        
        predictRecursive(result, pastValues.length, 
                       pastValues[pastValues.length - 1], 
                       futurePeriods);
        return result;
    }
    
    private void predictRecursive(double[] result, int currentIndex,
                                double lastValue, int remainingPeriods) {
        if (remainingPeriods == 0) return;
        
        double nextValue = lastValue * (1 + growthRate);
        result[currentIndex] = nextValue;
        predictRecursive(result, currentIndex + 1, nextValue, remainingPeriods - 1);
    }
}