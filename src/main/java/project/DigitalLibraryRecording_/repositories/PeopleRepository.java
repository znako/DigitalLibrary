package project.DigitalLibraryRecording_.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.DigitalLibraryRecording_.models.Person;

import java.util.Optional;

public interface PeopleRepository extends JpaRepository<Person, Integer> {
    Optional<Person> findByName(String name);
}
