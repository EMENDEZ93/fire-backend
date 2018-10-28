package em.fire.backend.controller.note;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import em.fire.backend.entity.note.NoteEntity;
import em.fire.backend.model.note.Note;
import em.fire.backend.domain.note.NoteService;

@RestController
public class NoteController {

	@Autowired
	@Qualifier("noteService")
	private NoteService noteService;
	
	@CrossOrigin(origins = "*")
	@PostMapping("/note/save")
	public boolean createUser(@Valid @RequestBody NoteEntity note) {
		return noteService.createNote(note);
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/notes")
	public List<NoteEntity> allNotes() {
		return noteService.findAll();
	}	
	
	@CrossOrigin(origins = "*")
	@GetMapping("/note/{id}/delete")
	public boolean deleteNote(@PathVariable(value="id") Long id) {
		return noteService.deleteNoteById(id);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/note/{id}")
	public NoteEntity getNote(@PathVariable(value="id") Long id) {
		return noteService.getNoteById(id);
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/notes/user/{idFirebase}")
	public List<Note> allNotesByIdFirebase(@PathVariable(value="idFirebase") String idFirebase) {
		return noteService.getNotesByIdFirebase(idFirebase);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/get/all/foreign/notes/by/email/guest/{emailGuest}")
	public List<Note> allForeignNotesByEmailGuest(@PathVariable(value="emailGuest") String emailGuest) {
		return noteService.allForeignNotesByEmailGuest(emailGuest);
	}
}
