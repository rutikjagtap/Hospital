package com.accio.SpringProject.Hospital.Controller;

import com.accio.SpringProject.Hospital.Entity.Patient;
import com.accio.SpringProject.Hospital.Model.PatientInput;
import com.accio.SpringProject.Hospital.Service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Hospital")
public class controller {

    private final PatientService patientService;

    public controller(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/Patient")
    public List<Patient> getPatients() {
        return patientService.getAllPatients();
    }

    @PostMapping("/addPatient")
    public Patient addPatient(@RequestBody PatientInput patientInput) {
        return patientService.addPatient(patientInput);
    }

    @PutMapping("/updatePatient/{id}")
    public List<Patient> updatePatient(@PathVariable long id, @RequestBody PatientInput input) {
        return patientService.updatePatient(id, input);
    }

    @DeleteMapping("/deletePatient/{id}")
    public ResponseEntity<Object> deletePatient(@PathVariable long id) {
        boolean deleted = patientService.deletePatient(id);
        if (!deleted) {
            return ResponseEntity.status(404).body("Patient not found!");
        }
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping("/Search")
    public List<Patient> searchPatient(@RequestParam String name) {
        return patientService.searchByName(name);
    }

    @GetMapping("/sort")
    public List<Patient> sort(@RequestParam(defaultValue = "name") String by) {
        return patientService.sortPatients(by);
    }
}
