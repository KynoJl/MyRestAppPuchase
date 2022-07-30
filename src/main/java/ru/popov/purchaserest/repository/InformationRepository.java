package ru.popov.purchaserest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.popov.purchaserest.models.Information;

@Repository
public interface InformationRepository extends JpaRepository<Information,Long> {
}
