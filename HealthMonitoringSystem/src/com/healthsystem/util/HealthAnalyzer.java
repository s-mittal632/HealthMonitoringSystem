package com.healthsystem.util;

import com.healthsystem.model.VitalSigns;

/**
 * Utility class for analyzing health data and providing assessments
 * Contains the core medical logic for evaluating vital signs
 */
public class HealthAnalyzer {
    
    /**
     * Analyze vital signs and provide a health assessment
     */
    public static String analyzeVitalSigns(VitalSigns vitalSigns) {
        int riskScore = 0;
        StringBuilder issues = new StringBuilder();
        
        // Heart rate analysis
        if (vitalSigns.getHeartRate() < 50) {
            riskScore += 3;
            issues.append("Very low heart rate. ");
        } else if (vitalSigns.getHeartRate() < 60) {
            riskScore += 1;
            issues.append("Low heart rate. ");
        } else if (vitalSigns.getHeartRate() > 120) {
            riskScore += 3;
            issues.append("Very high heart rate. ");
        } else if (vitalSigns.getHeartRate() > 100) {
            riskScore += 1;
            issues.append("High heart rate. ");
        }
        
        // Blood pressure analysis
        if (vitalSigns.getSystolicBP() > 180 || vitalSigns.getDiastolicBP() > 120) {
            riskScore += 4;
            issues.append("Dangerously high blood pressure! ");
        } else if (vitalSigns.getSystolicBP() > 140 || vitalSigns.getDiastolicBP() > 90) {
            riskScore += 2;
            issues.append("High blood pressure. ");
        }
        
        // Temperature analysis
        if (vitalSigns.getTemperature() > 39.0) {
            riskScore += 3;
            issues.append("High fever. ");
        } else if (vitalSigns.getTemperature() > 38.0) {
            riskScore += 1;
            issues.append("Fever. ");
        }
        
        // Oxygen analysis
        if (vitalSigns.getOxygenSaturation() < 90) {
            riskScore += 5;
            issues.append("Critically low oxygen! ");
        } else if (vitalSigns.getOxygenSaturation() < 95) {
            riskScore += 2;
            issues.append("Low oxygen level. ");
        }
        
        // Blood sugar analysis
        if (vitalSigns.getBloodSugar() > 240) {
            riskScore += 3;
            issues.append("Very high blood sugar. ");
        } else if (vitalSigns.getBloodSugar() > 180) {
            riskScore += 1;
            issues.append("High blood sugar. ");
        } else if (vitalSigns.getBloodSugar() < 70) {
            riskScore += 3;
            issues.append("Low blood sugar. ");
        }
        
        // Determine overall status
        if (riskScore >= 8) {
            return "CRITICAL - " + issues.toString() + "Seek immediate medical attention!";
        } else if (riskScore >= 5) {
            return "HIGH RISK - " + issues.toString() + "Consult doctor soon.";
        } else if (riskScore >= 3) {
            return "MODERATE RISK - " + issues.toString() + "Monitor closely.";
        } else if (riskScore >= 1) {
            return "MILD - " + issues.toString() + "Generally OK.";
        } else {
            return "NORMAL - All readings within normal ranges.";
        }
    }
    
    /**
     * Check if vital signs indicate emergency condition
     */
    public static boolean isEmergency(VitalSigns vitalSigns) {
        return vitalSigns.getHeartRate() < 40 || vitalSigns.getHeartRate() > 150 ||
               vitalSigns.getSystolicBP() > 180 || vitalSigns.getDiastolicBP() > 120 ||
               vitalSigns.getOxygenSaturation() < 90 ||
               vitalSigns.getTemperature() > 40.0 ||
               vitalSigns.getBloodSugar() < 50 || vitalSigns.getBloodSugar() > 400;
    }
}