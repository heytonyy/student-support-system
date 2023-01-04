package com.heytonyyy.studentsupportsystem.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heytonyyy.studentsupportsystem.models.Student;
import com.heytonyyy.studentsupportsystem.models.SupportNote;
import com.heytonyyy.studentsupportsystem.models.User;
import com.heytonyyy.studentsupportsystem.repositories.StudentRepository;
import com.heytonyyy.studentsupportsystem.repositories.SupportNoteRepository;
import com.heytonyyy.studentsupportsystem.repositories.UserRepository;

@Service
public class SupportNoteService {
	
	@Autowired
	UserRepository userRepo;
	@Autowired
	StudentRepository studentRepo;
	@Autowired
	SupportNoteRepository supportNoteRepo;
	
//	CREATE SUPPORT NOTE
	public SupportNote createSupportNote(SupportNote newSupportNote) {
		return supportNoteRepo.save(newSupportNote);
	}
	
//	ALL SUPPORT NOTES FOR GIVEN STUDENT AND GIVEN TEACHER
	public List<SupportNote> showAllSupportNotes(User teacher, Student student){
		List<SupportNote> allSupportNotes = supportNoteRepo.findAll();
		ArrayList<SupportNote> returnNotes = new ArrayList<SupportNote>();
		for (SupportNote note : allSupportNotes) {
			if (note.getStudent().equals(student) && note.getTeacher().equals(teacher)) {
				returnNotes.add(note);
			}
		}
		return returnNotes;
	}
	
}
