package com.healthsystem;

import com.healthsystem.model.Patient;
import com.healthsystem.model.VitalSigns;
import com.healthsystem.service.PatientService;
import com.healthsystem.service.MonitoringService;
import com.healthsystem.service.AlertService;
import com.healthsystem.util.HealthAnalyzer;

import java.util.*;

public class HealthApp {
    private static PatientService patientService = new PatientService();
    private static MonitoringService monitoringService = new MonitoringService();
    private static AlertService alertService = new AlertService();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=== Health Monitoring System ===");
        System.out.println("Initializing system...");
        
        initializeSystem();
        mainMenuLoop();
        scanner.close();
    }
    
    private static void initializeSystem() {
        patientService.addPatient("John Smith", 45, "Male", "john@email.com", "Hypertension");
        patientService.addPatient("Sarah Johnson", 32, "Female", "sarah@email.com", "None");
        System.out.println("✓ System initialized with sample patients");
    }
    
    private static void mainMenuLoop() {
        boolean running = true;
        while (running) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Register New Patient");
            System.out.println("2. Record Vital Signs");
            System.out.println("3. Check Patient Health");
            System.out.println("4. View Health Alerts");
            System.out.println("5. List All Patients");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");
            
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1": registerPatient(); break;
                case "2": recordVitalSigns(); break;
                case "3": checkHealth(); break;
                case "4": viewAlerts(); break;
                case "5": listPatients(); break;
                case "0": running = false; break;
                default: System.out.println("Invalid option");
            }
        }
    }
    
    private static void registerPatient() {
        System.out.println("\n--- PATIENT REGISTRATION ---");
        try {
            System.out.print("Full name: ");
            String name = scanner.nextLine();
            System.out.print("Age: ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.print("Gender: ");
            String gender = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Medical history: ");
            String history = scanner.nextLine();
            
            Patient patient = patientService.addPatient(name, age, gender, email, history);
            System.out.println("Patient registered! ID: " + patient.getId());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void recordVitalSigns() {
        System.out.println("\n--- RECORD VITAL SIGNS ---");
        System.out.print("Patient ID: ");
        String patientId = scanner.nextLine();
        
        try {
            System.out.print("Heart Rate (bpm): ");
            double hr = Double.parseDouble(scanner.nextLine());
            System.out.print("Systolic BP: ");
            double systolic = Double.parseDouble(scanner.nextLine());
            System.out.print("Diastolic BP: ");
            double diastolic = Double.parseDouble(scanner.nextLine());
            System.out.print("Temperature (°C): ");
            double temp = Double.parseDouble(scanner.nextLine());
            System.out.print("Oxygen (%): ");
            double oxygen = Double.parseDouble(scanner.nextLine());
            System.out.print("Blood Sugar: ");
            double sugar = Double.parseDouble(scanner.nextLine());
            
            VitalSigns vs = new VitalSigns(patientId, hr, systolic, diastolic, temp, oxygen, sugar);
            monitoringService.recordVitalSigns(patientId, vs);
            System.out.println("Vital signs recorded!");
            alertService.checkForAlerts(vs);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void checkHealth() {
        System.out.println("\n--- HEALTH CHECK ---");
        System.out.print("Patient ID: ");
        String patientId = scanner.nextLine();
        
        try {
            List<VitalSigns> history = monitoringService.getVitalHistory(patientId);
            if (history.isEmpty()) {
                System.out.println("No readings found");
                return;
            }
            VitalSigns latest = history.get(history.size() - 1);
            String status = HealthAnalyzer.analyzeVitalSigns(latest);
            System.out.println("Health Status: " + status);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void viewAlerts() {
        System.out.println("\n--- ALERTS ---");
        List<String> alerts = alertService.getActiveAlerts();
        if (alerts.isEmpty()) {
            System.out.println("No active alerts");
        } else {
            alerts.forEach(alert -> System.out.println(alert));
        }
    }
    
    private static void listPatients() {
        System.out.println("\n--- PATIENTS ---");
        patientService.getAllPatients().forEach(patient -> 
            System.out.println(patient.getId() + " - " + patient.getName()));
    }
}