package ru.popov.purchaserest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.popov.purchaserest.models.Person;
import ru.popov.purchaserest.models.Purchase;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository <Person, Long> {

        @Query("select w from Person w where w =(select t from Person t join Purchase p on t.id = p.person.id\n" +
                " where p.count = (SELECT max(p.count) from Purchase p where p.datePurchaseLocal <= CURRENT_DATE and p.datePurchaseLocal >= :localDateSixMonths))")
    List<Person> getSixMonths(@Param("localDateSixMonths") LocalDate localDateSixMonths);
}
