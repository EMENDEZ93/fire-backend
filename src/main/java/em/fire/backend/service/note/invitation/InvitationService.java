package em.fire.backend.service.note.invitation;

import java.util.List;

import em.fire.backend.entity.note.invitation.InvitationEntity;

public interface InvitationService {

	public InvitationEntity postInvitation(InvitationEntity invitation);
	
	public List<InvitationEntity> getAllInvitation();
	
	public boolean deleteInvitation(Long id);
	
	public boolean getInvitationStatusByNoteIdAndGuest(Long noteId, String guestEmail);
}
