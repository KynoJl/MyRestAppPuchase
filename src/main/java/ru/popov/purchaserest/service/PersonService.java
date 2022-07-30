package ru.popov.purchaserest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.popov.purchaserest.mapper.PersonMapper;
import ru.popov.purchaserest.models.Person;
import ru.popov.purchaserest.repository.PersonRepository;

import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
public class PersonService {


    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository userRepository) {
        this.personRepository = userRepository;
    }

    public List<Person> fundAll(){
        return personRepository.findAll();
    }

    public Person findOne(Long id) {
        Optional<Person> foundPerson = personRepository.findById(id);
        return foundPerson.orElse(null);
    }
    @Transactional
    public void saves(Person person){
        personRepository.save(person);
    }

    @Transactional
    public void delete(Long id) {
        personRepository.deleteById(id);
    }
    @Transactional
    public void update(Long id, Person person) {
       Person item = personRepository.findById(id).orElseThrow(RuntimeException::new);
       item.setName(person.getName());
        item.setLastName(person.getLastName());
        item.setAge(person.getAge());
    }
}
