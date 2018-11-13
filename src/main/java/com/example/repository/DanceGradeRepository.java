package com.example.repository;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.DanceGrade;

@Repository
public interface DanceGradeRepository extends JpaRepository<DanceGrade, Integer> {
	
}