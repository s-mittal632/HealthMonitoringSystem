package com.healthsystem.service;

import com.healthsystem.model.Patient;
import com.healthsystem.exception.PatientNotFoundException;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Service class for managing patient operations
 * Handles patient registration, retrieval, and management
 */
public class PatientService {
    private Map<String, Patient> patients;
    
    public PatientService() {
        // Using concurrent map for thread safety
        this.patients = new ConcurrentHashMap<>();
    }
    
    /**
     * Register a new patient in the system
     */
    public Patient addPatient(String name, int age, String gender, String email, String medicalHistory) {
        // Basic validation
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient name cannot be empty");
        }
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Age must be between 0 and 150");
        }
        
        Patient patient = new Patient(name, age, gender, email, medicalHistory);
        patients.put(patient.getId(), patient);
        
        return patient;
    }
    
    /**
     * Retrieve patient by ID
     */
    public Patient getPatient(String patientId) {
        Patient patient = patients.get(patientId);
        if (patient == null) {
            throw new PatientNotFoundException("Patient not found with ID: " + patientId);
        }
        return patient;
    }
    
    /**
     * Check if patient exists
     */
    public boolean patientExists(String patientId) {
        return patients.containsKey(patientId);
    }
    
    /**
     * Get all registered patients
     */
    public List<Patient> getAllPatients() {
        return new ArrayList<>(patients.values());
    }
    
    /**
     * Get total number of patients
     */
    public int getPatientCount() {
        return patients.size();
    }
    
    /**
     * Search patients by name (case-insensitive)
     */
    public List<Patient> searchPatients(String searchTerm) {
        List<Patient> results = new ArrayList<>();
        String searchLower = searchTerm.toLowerCase();
        
        for (Patient patient : patients.values()) {
            if (patient.getName().toLowerCase().contains(searchLower)) {
                results.add(patient);
            }
        }
        
        return results;
    }
}