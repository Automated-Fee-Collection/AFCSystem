package com.afcs.backend.payments;

import com.afcs.backend.arrivals.Arrivals;
import com.afcs.backend.arrivals.ArrivalsRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/record_payments")
public class PaymentPoster {
    private final ArrivalsRepository arrivalsRepository;
    private final PaymentRepository paymentRepository;

    public PaymentPoster(ArrivalsRepository arrivalsRepository, PaymentRepository paymentRepository) {
        this.arrivalsRepository = arrivalsRepository;
        this.paymentRepository = paymentRepository;
    }

    @PostMapping
    public String recordPayments() {
        List<Arrivals> arrivalsList = arrivalsRepository.findAll();
        String payment_status = "Pending";

        for (Arrivals arrivals: arrivalsList) {
            Payments payments = new Payments();
            payments.setId(arrivals.getId());
            payments.setPlate(arrivals.getPlate());
            payments.setBus_name(arrivals.getBus_name());
            payments.setArrival_time(arrivals.getArrival_time());
            payments.setFee(arrivals.getFee());
            payments.setPayment_status(payment_status);

            paymentRepository.save(payments);
        }
        return "Payments recorded successfully!";
    }
}
