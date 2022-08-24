package ru.popov.purchaserest.mapper;

import org.springframework.stereotype.Component;
import ru.popov.purchaserest.dto.PersonDto;
import ru.popov.purchaserest.models.Person;

@Component
public class PersonMapper {
    public PersonMapper() {

    }
    public Person convertToPerson(PersonDto personDto) {
        Person person =  new Person();
        person.setName(personDto.getName());
        person.setLastName(personDto.getLastName());
        person.setAge(personDto.getAge());
        return person;
    }
}
