package main.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class VideoGame extends Item{

	private IntegerProperty year;
	
	private StringProperty type;
	
	private StringProperty description;
	
	public VideoGame() {
		super();
		this.year = new SimpleIntegerProperty(1900);
		this.type = new SimpleStringProperty("DEFAULT");
		this.description = new SimpleStringProperty("This is a interesting game.");
	}
	
	public VideoGame(String name, int price, int year, String type, String description) {
		
		super(name, price);
		this.year = new SimpleIntegerProperty(year);
		this.type = new SimpleStringProperty(type);
		this.description = new SimpleStringProperty(description);
		
	}
	
	public int getYear() {
		return this.year.get();
	}
	
	public void setYear(int year) {
		this.year.set(year);
	}
	
	public IntegerProperty yearProperty() {
		return year;
	}
	
	public String getType() {
		return type.get();
	}
	
	public void setType(String type) {
		this.type.set(type);
	}
	
	public StringProperty typeProperty() {
		return type;
	}
	
	public String getDescription() {
		return description.get();
	}
	
	public void setDescription(String description) {
		this.description.set(description);
	}
	
	public StringProperty descriptionProperty() {
		return description;
	}

	
}
