# Health-Monitoring-System-Sampada-Mittal

## Overview
A Java-based console application for automated health monitoring that tracks patient vital signs and provides real-time health assessments. The system helps users identify potential health risks through intelligent analysis of vital signs data.

## Features
- Patient registration and management
- Vital signs recording (heart rate, blood pressure, temperature, oxygen, blood sugar)
- Automated health status analysis
- Real-time alert system for dangerous readings
- Patient history tracking
- Health report generation

## Technologies/tools used
- Java Programming Language
- Object-Oriented Programming
- Collections Framework
- VS Code IDE
- Git Version Control

## Steps to install & run the project

### Prerequisites
- Java JDK 11 or higher installed

### Installation Steps
1. Download the project files to your computer
2. Extract the files if they are in a zip folder
3. Open command prompt or terminal
4. Navigate to the project directory

### Run the Project
1. Compile the Java files:
   ```bash
   cd src
   javac com/healthsystem/HealthApp.java
   
### Run the application:
bash
java com.healthsystem.HealthApp

### Instructions for testing

Test Case 1: Patient Registration
1.Run the application
2.Select option 1 (Register New Patient)
3.Enter patient details:
  Name: John Doe
  Age: 35
  Gender: Male
  Email: john@email.com
  Medical History: None
4.Verify patient ID is generated successfully

Test Case 2: Record Vital Signs
1.Select option 2 (Record Vital Signs)
2.Enter the patient ID from previous test
3.Input vital signs:
  Heart Rate: 72
  Systolic BP: 120
  Diastolic BP: 80
  Temperature: 36.6
  Oxygen: 98
  Blood Sugar: 110
4.Verify "Vital signs recorded" message appears

Test Case 3: Check Health Status
1.Select option 3 (Check Patient Health)
2.Enter the patient ID
3.Verify health status is displayed (should show "NORMAL")

Test Case 4: Trigger Alerts
1.Select option 2 (Record Vital Signs)
2.Enter dangerous values to trigger alerts:
  Heart Rate: 130
  Oxygen: 85
  Blood Pressure: 150/95
  Temperature: 39.0
3.Select option 4 (View Health Alerts)
4.Verify alerts are displayed for dangerous readings

Test Case 5: List Patients
1.Select option 5 (List All Patients)
2.Verify all registered patients are displayed
