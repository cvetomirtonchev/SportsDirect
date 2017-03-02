package shops;

public abstract class Product {
	public enum Brand {
		NIKE,ADIDAS,PUMA,EVERLAST
	}
	private String name;
	private Brand brand;
	private boolean forMen;
	private String size;
	private int quantity;
	private String productInfo;
	
	public Product(String name, Brand brand, boolean forMen, String size, int quantity, String productInfo) {
		super();
		this.name = name;
		this.brand = brand;
		this.forMen = forMen;
		this.size = size;
		this.quantity = quantity;
		this.productInfo = productInfo;
	}
	
	
	
	

}