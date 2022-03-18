package com.uploadfile.demo.repositories;

import com.uploadfile.demo.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Person repository.
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByOrderByIdDesc();

}
