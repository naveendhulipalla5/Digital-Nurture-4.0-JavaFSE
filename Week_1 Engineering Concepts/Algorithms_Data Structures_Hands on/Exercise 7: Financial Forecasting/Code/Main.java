import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		FinancialData historicalData = new FinancialData(
	            "Quarterly Stock Prices", 
	            new double[]{100.0, 105.0, 110.25, 115.76}
	        );
	        
	       
	        FinancialForecaster forecaster = new FinancialForecaster(
	            historicalData.getValues()
	        );
	        
	      
	        int forecastPeriods = 4;
	        double[] forecast = forecaster.predict(forecastPeriods);
	        
	        
	        System.out.println("Financial Forecast for: " + historicalData.getLabel());
	        System.out.println("Historical Data:");
	        printPeriods(historicalData.getValues());
	        
	        System.out.println("\nForecasted Data:");
	        printPeriods(Arrays.copyOfRange(
	            forecast, 
	            historicalData.getPeriodCount(), 
	            forecast.length
	        ));
	    }
	    
	    private static void printPeriods(double[] values) {
	        for (int i = 0; i < values.length; i++) {
	            System.out.printf("Period %d: $%.2f%n", i+1, values[i]);
	        }
	}

}
