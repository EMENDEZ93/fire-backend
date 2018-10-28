package em.fire.backend.domain.note.invitation;

import java.util.List;

import em.fire.backend.model.user.Guest;
import em.fire.backend.entity.note.Note;
import em.fire.backend.entity.note.invitation.InvitationEntity;

public interface InvitationService {

	public InvitationEntity postInvitation(InvitationEntity invitation);
	
	public List<InvitationEntity> getAllInvitation();
	
	public boolean deleteInvitation(Long id);
	
	public boolean getInvitationStatusByNoteIdAndGuest(Long noteId, String guestEmail);

	public List<Note> getPendingInvitationsToNotesByGuest(String guestEmail);
	
	public List<Guest> getAllGuestsByNoteIdAndHost(Long noteId, String hostEmail);
	
	public InvitationEntity getChangeInvitationStatusByNodeIdAndGuestEmail(Long noteId, String guestEmail);
	
}
