package com.accio.SpringProject.Hospital.Service;

import com.accio.SpringProject.Hospital.Entity.Patient;
import com.accio.SpringProject.Hospital.Model.PatientInput;
import com.accio.SpringProject.Hospital.Repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PatientService {
    private final PatientRepository repository;

    public PatientService(PatientRepository repository) {
        this.repository = repository;
    }

    public List<Patient> getAllPatients() {
        return repository.findAll();
    }

    public Patient addPatient(PatientInput patientInput) {
        long id = repository.getNextId();
        Patient patient = new Patient(patientInput.getName(), patientInput.getAge(), id);
        return repository.save(patient);
    }

    public List<Patient> updatePatient(long id, PatientInput input) {
        Patient patient = repository.findById(id).orElse(null);
        if (patient != null) {
            patient.setName(input.getName());
            patient.setAge(input.getAge());
            return Collections.singletonList(patient);
        }
        return Collections.emptyList();
    }

    public boolean deletePatient(long id) {
        return repository.deleteById(id);
    }

    public List<Patient> searchByName(String name) {
        return repository.searchByName(name);
    }

    public List<Patient> sortPatients(String sortBy) {
        List<Patient> patients = new ArrayList<>(repository.findAll());
        switch (sortBy.toLowerCase()) {
            case "id":
                patients.sort((p1, p2) -> Long.compare(p1.getId(), p2.getId()));
                break;
            case "age":
                patients.sort((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));
                break;
            case "name":
            default:
                patients.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
                break;
        }
        return patients;
    }
}
