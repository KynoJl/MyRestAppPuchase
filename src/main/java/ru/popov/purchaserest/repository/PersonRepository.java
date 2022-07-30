package ru.popov.purchaserest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import ru.popov.purchaserest.models.Person;

import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository <Person, Long> {

}
