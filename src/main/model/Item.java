package main.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

public class Item {

	private StringProperty name;
	
	private IntegerProperty price;
	
	private StringProperty description;
	
	private Image img;
	
	public Item() {
		this(null);
	}
	
	public Item(String name) {
		
		this.setName(new SimpleStringProperty(name));
		
		
	}

	public StringProperty getName() {
		return name;
	}

	public void setName(StringProperty name) {
		this.name = name;
	}

	public IntegerProperty getPrice() {
		return price;
	}

	public void setPrice(IntegerProperty price) {
		this.price = price;
	}
	
}