package ru.popov.purchaserest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.popov.purchaserest.models.Person;
import ru.popov.purchaserest.models.Purchase;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {



    @Query("Select t from Purchase t where t.datePurchaseLocal <= CURRENT_DATE and t.datePurchaseLocal >= :lastWeekDate")
    List<Purchase> findLastWeek(@Param("lastWeekDate") LocalDate lastWeekDate);

    @Query ("Select w from Purchase w where w=(Select t from Purchase t where t.count = (select max(w.count) from Purchase w where w.datePurchaseLocal <= CURRENT_DATE and w.datePurchaseLocal >= :localDateMonths ))")
    List<Purchase> maxCount(@Param("localDateMonths") LocalDate localDateMonths) ;




}
