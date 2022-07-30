package ru.popov.purchaserest.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.popov.purchaserest.dto.PersonDto;
import ru.popov.purchaserest.models.Person;
import ru.popov.purchaserest.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/p")
public class PersonController {
  private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
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
        personService.saves(convertToPerson(personDto));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        personService.delete(id);
    }



    @PutMapping
    public void update(@RequestBody Person person){
        personService.update(person);
    }



  private Person convertToPerson(PersonDto personDto) {
      Person person =  new Person();
      person.setName(personDto.getName());
      person.setLastName(personDto.getLastName());
      person.setAge(personDto.getAge());

      return person;
  }
}
