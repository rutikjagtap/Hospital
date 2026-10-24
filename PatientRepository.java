package com.accio.SpringProject.Hospital.Repository;

import com.accio.SpringProject.Hospital.Entity.Patient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PatientRepository {
    private final List<Patient> patients = new ArrayList<>();
    private long idCounter;

    public PatientRepository(){
        patients.add(new Patient("Rutik", 25, 1L));
        patients.add(new Patient("Pratik", 28, 2L));
        idCounter = 2;
    }

    public List<Patient> findAll() {
        return new ArrayList<>(patients);
    }

    public Optional<Patient> findById(long id) {
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                return Optional.of(patient);
            }
        }
        return Optional.empty();
    }

    public Patient save(Patient patient) {
        patients.add(patient);
        return patient;
    }

    public boolean deleteById(long id) {
        for (Patient patient : new ArrayList<>(patients)) {
            if (patient.getId() == id) {
                patients.remove(patient);
                return true;
            }
        }
        return false;
    }

    public long getNextId() {
        return ++idCounter;
    }

    public List<Patient> searchByName(String name) {
        List<Patient> result = new ArrayList<>();
        for (Patient patient : patients) {
            if (patient.getName().equalsIgnoreCase(name)) {
                result.add(patient);
            }
        }
        return result;
    }
}
