package ru.popov.purchaserest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.popov.purchaserest.dto.InformationDto;
import ru.popov.purchaserest.models.Information;
import ru.popov.purchaserest.service.InformationService;

@RestController
@RequestMapping("/information")
public class InformationController {
    private InformationService informationService;

    @Autowired
    public InformationController(InformationService informationService) {
        this.informationService = informationService;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody InformationDto informationDto) {
        informationService.saves(convertToInformation(informationDto));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private Information convertToInformation(InformationDto informationDto) {
        Information information = new Information();
        information.setName(informationDto.getName());
        information.setLastName(informationDto.getLastName());
        information.setAge(informationDto.getAge());
        information.setCount(informationDto.getCount());
        information.setAmount(informationDto.getAmount());
        information.setPurchase_date(informationDto.getPurchase_date());
        information.setPurchase(informationDto.getPurchase());
        return information;
    }
}
