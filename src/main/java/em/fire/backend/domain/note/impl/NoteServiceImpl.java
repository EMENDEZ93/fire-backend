package em.fire.backend.domain.note.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import em.fire.backend.entity.note.Note;
import em.fire.backend.repository.note.NoteDSLRepository;
import em.fire.backend.repository.note.NoteJpaRepository;
import em.fire.backend.domain.note.NoteService;

@Service("noteService")
public class NoteServiceImpl implements NoteService {

	@Autowired
	@Qualifier("noteJpaRepository")
	private NoteJpaRepository noteJpaRepository; 

	@Autowired
	@Qualifier("noteDSLRepository")
	private NoteDSLRepository noteDSLRepository; 
	
	
	@Override
	public boolean createNote(Note note) {
		noteJpaRepository.save(note);
		return true;
	}

	@Override
	public List<Note> findAll() {
		return 	noteJpaRepository.findAll();
	}

	@Override
	public boolean deleteNoteById(Long id) {
		
		if(noteJpaRepository.existsById(id)) {
			noteJpaRepository.deleteById(id);	
		
			return true;
		}
		
		return false;
	}

	@Override
	public Note getNoteById(Long id) {
		return noteDSLRepository.getNoteById(id);
	}

	@Override
	public List<Note> getNotesByIdFirebase(String idFirebase) {
		return noteDSLRepository.getNotesByIdFirebase(idFirebase);
	} 
	
}
