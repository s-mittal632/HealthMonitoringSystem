package com.healthsystem.service;

import com.healthsystem.model.VitalSigns;
import java.util.*;

public class AlertService {
    private List<String> activeAlerts = new ArrayList<>();
    
    public void checkForAlerts(VitalSigns vitalSigns) {
        System.out.println("DEBUG: Checking alerts for patient " + vitalSigns.getPatientId());
        
        // Clear previous alerts for this patient
        activeAlerts.removeIf(alert -> alert.contains(vitalSigns.getPatientId()));
        
        // Check heart rate alerts
        if (vitalSigns.getHeartRate() > 120) {
            String alert = "High heart rate alert: " + vitalSigns.getHeartRate() + " bpm (Patient: " + vitalSigns.getPatientId() + ")";
            activeAlerts.add(alert);
            System.out.println(alert);
        }
        
        // Check oxygen alerts
        if (vitalSigns.getOxygenSaturation() < 92) {
            String alert = "Low oxygen alert: " + vitalSigns.getOxygenSaturation() + "% (Patient: " + vitalSigns.getPatientId() + ")";
            activeAlerts.add(alert);
            System.out.println(alert);
        }
        
        // Check blood pressure alerts
        if (vitalSigns.getSystolicBP() > 140) {
            String alert = "High blood pressure alert: " + vitalSigns.getSystolicBP() + " mmHg (Patient: " + vitalSigns.getPatientId() + ")";
            activeAlerts.add(alert);
            System.out.println(alert);
        }
        
        // Check temperature alerts
        if (vitalSigns.getTemperature() > 38.5) {
            String alert = "Fever alert: " + vitalSigns.getTemperature() + "°C (Patient: " + vitalSigns.getPatientId() + ")";
            activeAlerts.add(alert);
            System.out.println(alert);
        }
        
        System.out.println("Total alerts now: " + activeAlerts.size());
    }
    
    public List<String> getActiveAlerts() {
        System.out.println("Returning " + activeAlerts.size() + " alerts");
        return new ArrayList<>(activeAlerts);
    }
    
    public void clearAlerts() {
        activeAlerts.clear();
    }
}