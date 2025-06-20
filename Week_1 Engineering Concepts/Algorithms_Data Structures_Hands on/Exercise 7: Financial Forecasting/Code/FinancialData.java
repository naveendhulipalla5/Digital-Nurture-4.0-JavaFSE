public class FinancialData {
    private final double[] values;
    private final String label;
    
    public FinancialData(String label, double[] values) {
        this.label = label;
        this.values = values.clone();
    }
    
    public double[] getValues() {
        return values.clone();
    }
    
    public String getLabel() {
        return label;
    }
    
    public int getPeriodCount() {
        return values.length;
    }
}