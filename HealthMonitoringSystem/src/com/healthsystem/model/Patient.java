package com.healthsystem.model;

import java.util.Date;

/**
 * Patient model class representing a patient in the system
 * Stores basic patient information and medical details
 */
public class Patient {
    private String id;
    private String name;
    private int age;
    private String gender;
    private String email;
    private String medicalHistory;
    private Date registrationDate;
    
    // Counter for generating patient IDs
    private static int idCounter = 1000;
    
    public Patient(String name, int age, String gender, String email, String medicalHistory) {
        this.id = "P" + (++idCounter);
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.medicalHistory = medicalHistory;
        this.registrationDate = new Date();
    }
    
    // Getters and setters
    public String getId() { return id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getMedicalHistory() { return medicalHistory; }
    public void setMedicalHistory(String medicalHistory) { 
        this.medicalHistory = medicalHistory; 
    }
    
    public Date getRegistrationDate() { return registrationDate; }
    
    @Override
    public String toString() {
        return String.format("Patient[ID=%s, Name=%s, Age=%d]", id, name, age);
    }
}