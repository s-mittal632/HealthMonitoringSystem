package com.healthsystem.model;

import java.util.Date;

/**
 * Represents a set of vital signs measurements for a patient
 * Each instance records health metrics at a specific time
 */
public class VitalSigns {
    private String patientId;
    private double heartRate;        // beats per minute
    private double systolicBP;       // mmHg
    private double diastolicBP;      // mmHg  
    private double temperature;      // Celsius
    private double oxygenSaturation; // percentage
    private double bloodSugar;       // mg/dL
    private Date timestamp;
    
    // Normal ranges for reference
    public static final double NORMAL_HR_MIN = 60;
    public static final double NORMAL_HR_MAX = 100;
    public static final double NORMAL_SYSTOLIC_MAX = 120;
    public static final double NORMAL_DIASTOLIC_MAX = 80;
    
    public VitalSigns(String patientId, double heartRate, double systolicBP,
                     double diastolicBP, double temperature, double oxygenSaturation,
                     double bloodSugar) {
        this.patientId = patientId;
        this.heartRate = heartRate;
        this.systolicBP = systolicBP;
        this.diastolicBP = diastolicBP;
        this.temperature = temperature;
        this.oxygenSaturation = oxygenSaturation;
        this.bloodSugar = bloodSugar;
        this.timestamp = new Date();
    }
    
    // Getters
    public String getPatientId() { return patientId; }
    public double getHeartRate() { return heartRate; }
    public double getSystolicBP() { return systolicBP; }
    public double getDiastolicBP() { return diastolicBP; }
    public double getTemperature() { return temperature; }
    public double getOxygenSaturation() { return oxygenSaturation; }
    public double getBloodSugar() { return bloodSugar; }
    public Date getTimestamp() { return timestamp; }
    
    /**
     * Check if any readings are outside normal ranges
     */
    public boolean hasAbnormalReadings() {
        return heartRate < NORMAL_HR_MIN || heartRate > NORMAL_HR_MAX ||
               systolicBP > NORMAL_SYSTOLIC_MAX || diastolicBP > NORMAL_DIASTOLIC_MAX ||
               oxygenSaturation < 95;
    }
    
    @Override
    public String toString() {
        return String.format("Vitals[HR=%.0f, BP=%.0f/%.0f, Temp=%.1f]", 
                           heartRate, systolicBP, diastolicBP, temperature);
    }
}