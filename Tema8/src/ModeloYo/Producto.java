package ModeloYo;

import java.io.Serializable;

public class Producto implements Serializable {
	
    private static final long serialVersionUID = -3545287747348204339L;

	@Override
	public String toString() {
		return "Producto [id=" + id + ", name=" + name + ", supplier=" + supplier + ", unitsInStock=" + unitsInStock
				+ ", unitPrice=" + unitPrice + "]";
	}

	private int id;
    private String name;
    private int supplier;
    private int unitsInStock;
    private double unitPrice;
    
	public Producto(int id, String name, int supplier, int unitsInStock, double unitPrice) {
		super();
		this.id = id;
		this.name = name;
		this.supplier = supplier;
		this.unitsInStock = unitsInStock;
		this.unitPrice = unitPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSupplier() {
		return supplier;
	}

	public void setSupplier(int supplier) {
		this.supplier = supplier;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
	



	

}
