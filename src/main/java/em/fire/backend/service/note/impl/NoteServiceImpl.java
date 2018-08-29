package em.fire.backend.service.note.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import em.fire.backend.entity.note.Note;
import em.fire.backend.repository.note.NoteJpaRepository;
import em.fire.backend.service.note.NoteService;

@Service("noteService")
public class NoteServiceImpl implements NoteService {

	
	@Autowired
	@Qualifier("noteJpaRepository")
	private NoteJpaRepository noteJpaRepository; 
	
	@Override
	public boolean createNote(Note note) {
		noteJpaRepository.save(note);
		return true;
	} 
	
}
