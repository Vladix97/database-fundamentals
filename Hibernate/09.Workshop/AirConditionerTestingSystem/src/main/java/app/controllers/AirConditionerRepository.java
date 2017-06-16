package app.controllers;

import app.domains.entities.airConditioners.AbstractAirConditioner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AirConditionerRepository<E extends AbstractAirConditioner> extends JpaRepository<E, Long> {
}
