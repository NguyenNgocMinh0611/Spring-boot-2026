package com.springmasterclass.study.bai5.service.impl;

import com.springmasterclass.study.bai5.dto.record.PatientResponseDTO;
import com.springmasterclass.study.bai5.entity.Checkup;
import com.springmasterclass.study.bai5.entity.Patient;
import com.springmasterclass.study.bai5.repository.PatientRepository;
import com.springmasterclass.study.bai5.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Transactional(readOnly = true)
    public List<PatientResponseDTO> getPatientsWithNPlusOne() {
        // (1) Bắn 1 câu query lấy N bệnh nhân
        List<Patient> patients = patientRepository.findAll();

        // (2) Bắn thêm N câu query bên trong vòng lặp map
        return patients.stream().map(p -> {
            List<String> diagnoses = p.getCheckups().stream()
                    .map(Checkup::getDiagnosis)
                    .toList();
            return new PatientResponseDTO(p.getId(), p.getFullName(), diagnoses);
        }).toList(); // CGLIB Proxy
    }


}
