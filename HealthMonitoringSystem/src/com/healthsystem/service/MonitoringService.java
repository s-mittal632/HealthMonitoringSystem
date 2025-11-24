package com.healthsystem.service;

import com.healthsystem.model.VitalSigns;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MonitoringService {
    private Map<String, List<VitalSigns>> patientVitals = new ConcurrentHashMap<>();
    
    public void recordVitalSigns(String patientId, VitalSigns vitalSigns) {
        patientVitals.putIfAbsent(patientId, new ArrayList<>());
        patientVitals.get(patientId).add(vitalSigns);
    }
    
    public List<VitalSigns> getVitalHistory(String patientId) {
        return patientVitals.getOrDefault(patientId, new ArrayList<>());
    }
}