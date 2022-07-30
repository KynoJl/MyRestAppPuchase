package ru.popov.purchaserest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.popov.purchaserest.models.Information;
import ru.popov.purchaserest.repository.InformationRepository;

@Service
public class InformationService {
   private InformationRepository informationRepository;
   @Autowired
   public InformationService(InformationRepository informationRepository) {
      this.informationRepository = informationRepository;
   }

   public void saves(Information information) {
      informationRepository.save(information);
   }
}
