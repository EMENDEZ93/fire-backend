package em.fire.backend.service.note.invitation.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import em.fire.backend.entity.note.invitation.InvitationEntity;
import em.fire.backend.repository.note.invitation.InvitationDSLRepository;
import em.fire.backend.repository.note.invitation.InvitationJpaRepository;
import em.fire.backend.service.note.invitation.InvitationService;

@Service("invitationService")
public class InvitationServiceImpl implements InvitationService {

	@Autowired
	@Qualifier("invitationJpaRepository")
	private InvitationJpaRepository invitationJpaRepository;

	@Autowired
	@Qualifier("invitationDSLRepository")
	private InvitationDSLRepository invitationDSLRepository;

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
	public boolean getInvitationStatusByNoteIdAndGuest(Long noteId, String guestEmail) {
		return invitationDSLRepository.getInvitationStatusByNoteIdAndGuest(noteId, guestEmail);
	}

}
