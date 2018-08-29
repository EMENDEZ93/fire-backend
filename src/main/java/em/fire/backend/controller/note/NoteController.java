package em.fire.backend.controller.note;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	
}
