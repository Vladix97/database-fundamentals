package app.service;

import app.domain.dto.PersonDto;

public interface PersonService {

    void persist(PersonDto person);

    PersonDto findById(Long id);
}
