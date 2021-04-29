package com.itesting.SBDemo.respositories;

import com.itesting.SBDemo.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
