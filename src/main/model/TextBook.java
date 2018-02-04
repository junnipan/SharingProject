package main.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TextBook extends Item{

	private IntegerProperty version;
	
	private StringProperty courseId;
	
	private StringProperty description;
	
	public TextBook() {
		
		super();
		this.version = new SimpleIntegerProperty(1);
		this.courseId = new SimpleStringProperty("DEFAULT");
		this.description = new SimpleStringProperty("This is a important book.");
		
	}
	
	public TextBook(String name, int price, int version, String courseId, String description) {
		
		super(name, price);
		this.version = new SimpleIntegerProperty(version);
		this.courseId = new SimpleStringProperty(courseId);
		this.description = new SimpleStringProperty(description);
		
	}
	
	
	public int getVersion() {
		return version.get();
	}
	
	public void setVersion(int version) {
		this.version.set(version);
	}
	
	public IntegerProperty versionProperty() {
		return version;
	}
	
	public String getCourseId() {
		return this.courseId.get();
	}
	
	public void setVersion(String courseId) {
		this.courseId.set(courseId);
	}
	
	public StringProperty courseIdProperty() {
		return courseId;
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
