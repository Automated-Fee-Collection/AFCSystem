package com.afcs.backend.capture;

import com.afcs.backend.bus.Bus;
import com.afcs.backend.bus.BusRepository;
import com.afcs.backend.sms.SmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/capture")
public class CaptureController {

    @Autowired
    private final BusRepository busRepository;

    @Autowired
    private final CaptureRepository captureRepository;

    @Autowired
    private final SmsSender smsSender;

    public CaptureController(BusRepository busRepository, CaptureRepository captureRepository, SmsSender smsSender) {
        this.busRepository = busRepository;
        this.captureRepository = captureRepository;
        this.smsSender = smsSender;
    }

    @PostMapping
    public String recordArrival(@RequestBody CaptureRequest request) {
        String plate = request.getPlate();

        Bus bus = busRepository.findById(plate).orElse(null);
        if (bus == null) {
            return "Bus with plate " + plate + " not found!";
        }

        double fee = determineBusFee(bus.getRoute());

        // Save capture
        Capture capture = new Capture();
        capture.setPlate(bus.getPlate());
        capture.setBus_name(bus.getBus_name());
        capture.setBus_fee(fee);
        captureRepository.save(capture);

        // Send SMS
        String phone = bus.getOwner_phone();
        smsSender.sendSms(phone, plate, fee);

        return "Arrival recorded successfully!";
    }

    private double determineBusFee(String route) {
        return switch (route) {
            case "DOM-DAR", "DAR-MTW" -> 10000;
            case "DOM-MOR", "DOM-SIN", "SHY-MWZ" -> 5000;
            case "DOM-MWZ", "DOM-KAH" -> 12000;
            case "DAR-MWZ", "MOR-MWZ", "DAR-KAH" -> 15000;
            case "DAR-BUK" -> 17000;
            default -> 10000;
        };
    }

}
