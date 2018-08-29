package em.fire.backend.controller.note;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import em.fire.backend.entity.note.Note;
import em.fire.backend.service.note.NoteService;

@RestController
public class NoteController {

	@Autowired
	@Qualifier("noteService")
	private NoteService noteService;
	
	
	@PostMapping("/note/save")
	public boolean createUser(@Valid @RequestBody Note note) {
		return noteService.createNote(note);
	}

	@GetMapping("/notes")
	public List<Note> allNotes() {
		return noteService.findAll();
	}	
	
	@DeleteMapping("/note/{id}/delete")
	public boolean deleteNote(@PathVariable(value="id") Long id) {
		return noteService.deleteNoteById(id);
	}
	
	@GetMapping("/note/{id}")
	public Note getNote(@PathVariable(value="id") Long id) {
		return noteService.getNoteById(id);
	}
	
}
