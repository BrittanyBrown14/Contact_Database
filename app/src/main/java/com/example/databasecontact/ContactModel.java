package com.example.databasecontact;


public class ContactModel {

    private int ID;
    private String firstName;
    private String lastName;
    private String email;
    private String DOB;
    private boolean isActive;

    //constructor

    public ContactModel(int ID, String firstName, String lastName, String email, String DOB, boolean isActive) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.DOB = DOB;
        this.isActive = isActive;
    }

    public String toString()
    {
        return  "\nID: "+ ID +
                "\nFirst Name: " + firstName +
                "\nLast Name: " + lastName +
                "\nEmail: " + email +
                "\nDOB: " + DOB +
                "\nisActive: " + isActive + "\n";
    }
    //getters and setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
