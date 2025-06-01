package com.example.library_spring.person;

import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PersonService {

    PersonRepository personRepository;

    public List<PersonEntity> findAll() {
        return personRepository.findAll();
    }

    public PersonEntity save(PersonEntity personEntity) {
        return personRepository.save(personEntity);
    }

    public PersonEntity findById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Person not found with ID: " + id));
    }

    public void delete(Long id) {
        PersonEntity person = personRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Person not found with ID: " + id));
        personRepository.delete(person);
    }

    public PersonEntity update(Long id, PersonEntity updatedPerson) {
        PersonEntity existingPerson = personRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Person not found with ID: " + id));

        if (updatedPerson.getFirstName() != null) {
            existingPerson.setFirstName(updatedPerson.getFirstName());
        }

        if (updatedPerson.getLastName() != null) {
            existingPerson.setLastName(updatedPerson.getLastName());
        }

        return personRepository.save(existingPerson);
    }
}
