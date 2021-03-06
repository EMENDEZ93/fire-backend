package em.fire.backend.controller.note;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import em.fire.backend.model.user.Guest;
import em.fire.backend.entity.note.NoteEntity;
import em.fire.backend.entity.note.invitation.InvitationEntity;
import em.fire.backend.domain.note.invitation.InvitationService;

@RestController
public class InvitationController {

	@Autowired
	@Qualifier("invitationService")
	private InvitationService invitationService;
	
	@CrossOrigin(origins = "*")
	@PostMapping("/post/invitation")
	public InvitationEntity postInvitation(@Valid @RequestBody InvitationEntity invitation) {
		return invitationService.postInvitation(invitation);
	}	
	
	@CrossOrigin(origins = "*")
	@GetMapping("/invitations")
	public List<InvitationEntity> getAllInvitations() {
		return invitationService.getAllInvitation();
	}	
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/delete/{id}/invitation")
	public boolean deleteInvitation(@PathVariable(value="id") Long id) {
		return invitationService.deleteInvitation(id);
	}
		
	@CrossOrigin(origins = "*")
	@GetMapping("/get/pending/invitations/to/notes/by/guest/{guestEmail}")
	public List<NoteEntity> getPendingInvitationsToNotesByGuest(@PathVariable(value="guestEmail") String guestEmail) {
		return invitationService.getPendingInvitationsToNotesByGuest(guestEmail);
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/get/all/guests/by/notesid/{noteId}/and/host/{hostEmail}")
	public List<Guest> getAllGuestsByNoteIdAndHost(@PathVariable(value="noteId") Long noteId, @PathVariable(value="hostEmail") String hostEmail) {
		return invitationService.getAllGuestsByNoteIdAndHost(noteId, hostEmail);
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/get/change/invitation/status/by/nodeid/{noteId}/and/guest/{guestEmail}")
	public InvitationEntity getChangeInvitationStatusByNodeIdAndGuestEmail(@PathVariable(value="noteId") Long noteId, @PathVariable(value="guestEmail") String guestEmail) {
		return invitationService.getChangeInvitationStatusByNodeIdAndGuestEmail(noteId, guestEmail);
	}	
	
}
