package com.cms.demo.CitizenLiseningSystem.service.impl;

import com.cms.demo.CitizenLiseningSystem.entity.Citizen;
import com.cms.demo.CitizenLiseningSystem.entity.Payment;
import com.cms.demo.CitizenLiseningSystem.exception.UserAlreadyExists;
import com.cms.demo.CitizenLiseningSystem.repository.CitizenRepository;
import com.cms.demo.CitizenLiseningSystem.repository.PaymentRepository;
import com.cms.demo.CitizenLiseningSystem.service.CitizenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
public class CitizenServiceImpl implements CitizenService {

    private final CitizenRepository citizenRepository;

    private final PaymentRepository paymentRepository;

    @Override
    public Citizen createLicenseRegistration(String userName,Citizen citizen) {
        boolean isExits=citizenRepository.existsByPanNo(citizen.getPanNo());
        if(isExits){
            throw new UserAlreadyExists("citizen already exists");
        }
        citizen.setUserName(userName);
        citizen.setSubmitted(true);
        citizen.setStatus("verification-pending");
        return citizenRepository.save(citizen);
    }

    @Override

    public Payment createPaymentForCitizen(String userName,Payment payment) {
        boolean isExits=paymentRepository.existsByUserName(userName);
        if(isExits){
            throw new UserAlreadyExists("payment already exists");
        }
        payment.setUserName(userName);
        payment.setSubmitted(true);
        payment.setStatus("payment completed");
        return paymentRepository.save(payment);
    }

    @Override
    public Citizen getLicenseRegistration(String userName) {
        return citizenRepository.findByUserName(userName)
                .orElseThrow(()-> new NoSuchElementException("username "+userName + "not exist"));
    }

    @Override
    public Payment getPaymentForCitizen(String userName) {
        return paymentRepository.findByUserName(userName)
                .orElseThrow(()->new NoSuchElementException("payment with username "+userName + "not exist"));
    }
}
