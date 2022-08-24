package ru.popov.purchaserest.mapper;

import org.springframework.stereotype.Component;
import ru.popov.purchaserest.dto.PurchaseDto;
import ru.popov.purchaserest.models.Purchase;

import java.time.LocalDate;

@Component
public class PurchaseMapper {

    public PurchaseMapper() {
    }

    public Purchase convertToPurchase(PurchaseDto purchaseDto){
        Purchase purchase = new Purchase();
        purchase.setName(purchaseDto.getName());
        purchase.setCount(purchaseDto.getCount());
        LocalDate date= LocalDate.parse(purchaseDto.getDataPurchase());
        purchase.setDatePurchaseLocal(date);
        purchase.setPerson(purchaseDto.getPerson());
        purchase.setProduct(purchaseDto.getProduct());
        return purchase;
    }


}
