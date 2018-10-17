package em.fire.backend.service.note.invitation.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import em.fire.backend.entity.note.Note;
import em.fire.backend.entity.note.invitation.InvitationEntity;
import em.fire.backend.entity.user.User;
import em.fire.backend.repository.note.invitation.InvitationDSLRepository;
import em.fire.backend.repository.note.invitation.InvitationJpaRepository;
import em.fire.backend.service.note.NoteService;
import em.fire.backend.service.note.invitation.InvitationService;
import em.fire.backend.service.user.UserService;

@Service("invitationService")
public class InvitationServiceImpl implements InvitationService {

	@Autowired
	@Qualifier("invitationJpaRepository")
	private InvitationJpaRepository invitationJpaRepository;

	@Autowired
	@Qualifier("invitationDSLRepository")
	private InvitationDSLRepository invitationDSLRepository;

	@Autowired
	@Qualifier("noteService")
	private NoteService noteService;

	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	
	@Override
	public InvitationEntity postInvitation(InvitationEntity invitation) {
		return invitationJpaRepository.save(invitation);
	}

	@Override
	public List<InvitationEntity> getAllInvitation() {
		return invitationJpaRepository.findAll();
	}

	@Override
	public boolean deleteInvitation(Long id) {

		if (invitationJpaRepository.existsById(id)) {
			invitationJpaRepository.deleteById(id);
			return true;
		}

		return false;
	}

	@Override
	public InvitationEntity getInvitationStatusByNoteIdAndGuest(Long noteId, String guestEmail) {
		return invitationDSLRepository.getInvitationStatusByNoteIdAndGuest(noteId, guestEmail);
	}

	@Override
	public List<Note> getPendingInvitationsToNotesByGuest(String guestEmail) {
		List<Note> pendingInvitationsToNote = new ArrayList<>();
		invitationDSLRepository.getPendingInvitationsToNotesByGuest(guestEmail).stream().forEach( pendingInvitationEntities -> { 
			pendingInvitationsToNote.add( noteService.getNoteById( pendingInvitationEntities.getIdNote() ));
		});
		
		return pendingInvitationsToNote;
	}

	@Override
	public List<User> getAllGuestsByNoteIdAndHost(Long noteId, String hostEmail) {
		List<User> users = new ArrayList<>();
		invitationDSLRepository.getAllGuestsByNoteIdAndHost(noteId, hostEmail).stream().forEach(guestEmail -> {
			users.add( this.userService.getUserByEmail(guestEmail) );
		});
		return users;
	}

	@Override
	public InvitationEntity getChangeInvitationStatusByNodeIdAndGuestEmail(Long noteId, String guestEmail) {
		InvitationEntity invitationEntity = invitationDSLRepository.getInvitationByNoteIdAndGuestEmail(noteId, guestEmail);
		invitationEntity.setStatus(!invitationEntity.isStatus());
		
		return invitationJpaRepository.save(invitationEntity);
	}

	

}
