package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.model.DanceGrade;
import com.example.repository.DanceGradeRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class DanceGradeService {

	@Autowired
	private DanceGradeRepository danceGradeRepository;

	public List<DanceGrade> findAll() {
		return danceGradeRepository.findAll();
	}
	
	public Optional<DanceGrade> findOne(Integer id) {
		return danceGradeRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public DanceGrade save(DanceGrade entity) {
		return danceGradeRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(DanceGrade entity) {
		danceGradeRepository.delete(entity);
	}

}
	
