package em.fire.backend.domain.note;

import java.util.List;

import em.fire.backend.entity.note.NoteEntity;
import em.fire.backend.model.note.Note;

public interface NoteService {

	public boolean createNote(NoteEntity note);

	public List<NoteEntity> findAll();
	
	public boolean deleteNoteById(Long id);
	
	public NoteEntity getNoteById(Long id);
	
	public List<Note> getNotesByIdFirebase(String idFirebase);

	public List<Note> allForeignNotesByEmailGuest(String emailGuest);
	
}
