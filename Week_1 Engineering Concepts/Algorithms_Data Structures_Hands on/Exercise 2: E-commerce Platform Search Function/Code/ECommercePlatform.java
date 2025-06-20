
public class ECommercePlatform {

	public static void main(String[] args) {
		Product[] products = {
	            new Product("P100", "Laptop", "Electronics"),
	            new Product("P203", "Smartphone", "Electronics"),
	            new Product("P045", "Desk Chair", "Furniture"),
	            new Product("P302", "Coffee Maker", "Appliances")
	        };

	        
	        Product[] sortedProducts = {
	            new Product("P045", "Desk Chair", "Furniture"),
	            new Product("P100", "Laptop", "Electronics"),
	            new Product("P203", "Smartphone", "Electronics"),
	            new Product("P302", "Coffee Maker", "Appliances")
	        };

	        
	        String targetId = "P203";
	        
	        System.out.println("Linear Search Result:");
	        Product resultLinear = SearchAlgorithms.linearSearch(products, targetId);
	        System.out.println(resultLinear != null ? resultLinear : "Product not found");

	        System.out.println("\nBinary Search Result:");
	        Product resultBinary = SearchAlgorithms.binarySearch(sortedProducts, targetId);
	        System.out.println(resultBinary != null ? resultBinary : "Product not found");

	}

}
