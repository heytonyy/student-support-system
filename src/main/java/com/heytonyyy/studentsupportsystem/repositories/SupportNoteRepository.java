package com.heytonyyy.studentsupportsystem.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.heytonyyy.studentsupportsystem.models.SupportNote;

@Repository
public interface SupportNoteRepository extends CrudRepository<SupportNote, Long> {
	List<SupportNote> findAll();
	
}
