package ru.popov.purchaserest.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.popov.purchaserest.dto.PersonDto;
import ru.popov.purchaserest.mapper.PersonMapper;
import ru.popov.purchaserest.models.Person;
import ru.popov.purchaserest.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
  private final PersonService personService;
  private final PersonMapper personMapper;

    @Autowired
    public PersonController(PersonService personService, PersonMapper personMapper) {
        this.personService = personService;
        this.personMapper = personMapper;
    }


    @GetMapping("/")
    public List<Person> getPersons(){
        return personService.fundAll();
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Long id){

      return personService.findOne(id);
    }

    @PostMapping
    public ResponseEntity <HttpStatus> create(@RequestBody PersonDto personDto){
        personService.saves(personMapper.convertToPerson(personDto));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        personService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id,@RequestBody PersonDto personDto){
        personService.update(id,personMapper.convertToPerson(personDto));
    }




}
