package com.afcs.backend.payments;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/payments")
public class PaymentGetter {
    private final PaymentRepository paymentRepository;

    public PaymentGetter(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @GetMapping
    public List<Payments> getPayments(){
        return paymentRepository.findAll();
    }
}
