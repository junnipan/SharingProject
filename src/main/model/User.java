package main.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {

	private StringProperty email;
	private StringProperty username;
	private StringProperty password;
	private StringProperty university;
	private IntegerProperty year;
	
	public User() {
		this("mcmaster@gmail.com", "admin", "admin", "admin", "McMaster", 2019);
	}
	
	public User(String email, String username, String password, String rpassword, String university, int year) {
		
		if(check()) {
			this.email = new SimpleStringProperty(email);
			this.username = new SimpleStringProperty(username);
	        this.password = new SimpleStringProperty(password);

	        // Some initial dummy data, just for convenient testing.
	        this.university = new SimpleStringProperty("McMaster");
	        this.year = new SimpleIntegerProperty(year);
		} else {
			
		}
		
	}
	
	private boolean check() {
		
		return true;
	}

	public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public StringProperty emailProperty() {
        return email;
    }

	public String getUsername() {
		return username.get();
	}
	
	public void setUsername(String username) {
		this.username.set(username);
	}
	
	public StringProperty usernameProperty() {
		return username;
	}
	
	public String getPassword() {
		return password.get();
	}
	
	public void setPassword(String password) {
		this.password.set(password);
	}
	
	public StringProperty passwordProperty() {
		return password;
	}
	
	public String getUniversity() {
		return university.get();
	}
	
	public void setUniversity(String university) {
		this.university.set(university);
	}
	
	public StringProperty universityProperty() {
		return university;
	}
	
	public int getYear() {
		return year.get();
	}
	
	public void setYear(int year) {
		this.year.set(year);
	}
	
	public IntegerProperty yearProperty() {
		return year;
	}
	
}
