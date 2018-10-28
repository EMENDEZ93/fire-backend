package em.fire.backend.domain.note.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import em.fire.backend.entity.note.NoteEntity;
import em.fire.backend.model.note.Note;
import em.fire.backend.repository.note.NoteDSLRepository;
import em.fire.backend.repository.note.NoteJpaRepository;
import em.fire.backend.repository.note.invitation.InvitationDSLRepository;
import em.fire.backend.domain.note.NoteService;

@Service("noteService")
public class NoteServiceImpl implements NoteService {

	@Autowired
	@Qualifier("noteJpaRepository")
	private NoteJpaRepository noteJpaRepository; 

	@Autowired
	@Qualifier("noteDSLRepository")
	private NoteDSLRepository noteDSLRepository; 
	
	@Autowired
	@Qualifier("invitationDSLRepository")
	private InvitationDSLRepository invitationDSLRepository;
	
	@Override
	public boolean createNote(NoteEntity note) {
		noteJpaRepository.save(note);
		return true;
	}

	@Override
	public List<NoteEntity> findAll() {
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
	public NoteEntity getNoteById(Long id) {
		return noteDSLRepository.getNoteById(id);
	}

	@Override
	public List<Note> getNotesByIdFirebase(String idFirebase) {
		List<Note> notes = new ArrayList<>();
		noteDSLRepository.getNotesByIdFirebase(idFirebase).stream().forEach(noteEntity -> {
			notes.add(new Note(noteEntity, true));
		});
		
		return notes;
	}

	@Override
	public List<Note> allForeignNotesByEmailGuest(String emailGuest) {
		List<Note> notes = new ArrayList<Note>();
		invitationDSLRepository.allInvitationToNotesByEmailGuest(emailGuest).stream().forEach(invitationEntity -> {
			notes.add(new Note(noteDSLRepository.getNoteById(invitationEntity.getIdNote()), false)); 
		});
		
		notes.stream().forEach(System.out::println);
		
		return notes;
	} 
	
}
