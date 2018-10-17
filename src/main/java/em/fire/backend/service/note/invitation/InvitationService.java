package em.fire.backend.service.note.invitation;

import java.util.List;

import em.fire.backend.entity.note.Note;
import em.fire.backend.entity.note.invitation.InvitationEntity;
import em.fire.backend.entity.user.User;

public interface InvitationService {

	public InvitationEntity postInvitation(InvitationEntity invitation);
	
	public List<InvitationEntity> getAllInvitation();
	
	public boolean deleteInvitation(Long id);
	
	public boolean getInvitationStatusByNoteIdAndGuest(Long noteId, String guestEmail);

	public List<Note> getPendingInvitationsToNotesByGuest(String guestEmail);
	
	public List<User> getAllGuestsByNoteIdAndHost(Long noteId, String hostEmail);
	
	public InvitationEntity getChangeInvitationStatusByNodeIdAndGuestEmail(Long noteId, String guestEmail);
	
}
