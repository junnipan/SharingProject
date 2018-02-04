package main.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

public class Item {

	private StringProperty name;
	
	private IntegerProperty price;
	
	private Image img;
	
	public Item() {
		this("McHacks", 200);
	}
	
	public Item(String name, int price) {
		
		this.setName(name);
		this.setPrice(price);
		
	}

	public String getName() {	
		return name.get();	
	}
	
	public void setName(String name) {
		this.name.set(name);
	}
	
	public StringProperty nameProperty() {
		return name;
	}
	
	public int getPrice() {
		return price.get();
	}
	
	public void setPrice(int price) {
		this.price.set(price);
	}
	
	public IntegerProperty priceProperty() {
		return price;
	}
	
	
}
