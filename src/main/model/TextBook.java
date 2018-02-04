package main.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class TextBook extends Item{

	private IntegerProperty version;
	
	private StringProperty courseId;
	
	private StringProperty description;
	
	public TextBook() {
		super();
		this.version.set(1);
		this.courseId.set("DEFAULT");
		this.description.set("This is a important book.");
	}
	
	public TextBook(String name, int price, int version, String courseId, String description) {
		
		super(name, price);
		this.version.set(version);
		this.courseId.set(courseId);
		this.description.set(description);
		
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
