package em.fire.backend.service.note;

import java.util.List;

import em.fire.backend.entity.note.Note;

public interface NoteService {

	public boolean createNote(Note note);

	public List<Note> findAll();
	
	public boolean deleteNoteById(Long id);
	
	public Note getNoteById(Long id);
	
}
