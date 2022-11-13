package com.springcsvfile.csvfile.repository;


import com.springcsvfile.csvfile.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
}
