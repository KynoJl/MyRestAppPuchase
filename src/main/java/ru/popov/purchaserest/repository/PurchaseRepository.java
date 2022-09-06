package ru.popov.purchaserest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.popov.purchaserest.models.Person;
import ru.popov.purchaserest.models.Purchase;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {



    @Query("Select t from Purchase t where t.datePurchaseLocal <= CURRENT_DATE and t.datePurchaseLocal >= :lastWeekDate")
    List<Purchase> findLastWeek(@Param("lastWeekDate") LocalDate lastWeekDate);

    @Query ("select distinct t from Purchase  t where t.datePurchaseLocal <= CURRENT_DATE and t.datePurchaseLocal >= :localDateMonths and t.count = (select distinct max(w.count) from Purchase w)")
    List<Purchase> maxCount(@Param("localDateMonths") LocalDate localDateMonths) ;

    @Query("select t from Purchase t where t.person.age = 18")
    List<Purchase> findAge18();

   @Query("select t from Purchase t where t.datePurchaseLocal <= CURRENT_DATE and t.datePurchaseLocal >= :localDateSixMonths and t.count = (select distinct max(w.count) from Purchase w)")
    List<Purchase> getSixMonths(@Param("localDateSixMonths")LocalDate localDateSixMonths);
}
