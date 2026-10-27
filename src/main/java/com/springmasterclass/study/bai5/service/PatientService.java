package com.springmasterclass.study.bai5.service;

import com.springmasterclass.study.bai5.dto.record.PatientResponseDTO;

import java.util.List;

public interface PatientService {

    List<PatientResponseDTO> getPatientsWithNPlusOne();
}
