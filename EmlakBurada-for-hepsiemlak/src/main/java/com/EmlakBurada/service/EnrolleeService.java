package com.EmlakBurada.service;

import com.EmlakBurada.dto.request.AdvertRequest;
import com.EmlakBurada.dto.request.EnrolleeRequest;
import com.EmlakBurada.model.Enrollee;
import com.EmlakBurada.repository.AdvertRepository;
import com.EmlakBurada.repository.EnrolleeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrolleeService extends EnrolleeBaseService{

    @Autowired
    EnrolleeRepository enrolleeRepository;

    @Autowired
    private AdvertRepository advertRepository;

    public void saveEnrollee(EnrolleeRequest enrolleeRequest){
       enrolleeRepository.save(convertToEnrolleeEntity(enrolleeRequest));
    }

    public void deleteEnrollee(int enrolleeId){
        enrolleeRepository.deleteById(enrolleeId);
    }

    public void editEnrollee(EnrolleeRequest enrolleeRequest,int enrolleeId){
        enrolleeRepository.save(convertToEnrolleeEntity(enrolleeRequest));
    }
}
