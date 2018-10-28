package em.fire.backend.repository.note.invitation;

import javax.persistence.PersistenceContext;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQuery;

import em.fire.backend.entity.note.invitation.InvitationEntity;
import em.fire.backend.entity.note.invitation.QInvitationEntity;

@Repository("invitationDSLRepository")
public class InvitationDSLRepository {

	private QInvitationEntity qInvitationEntity = QInvitationEntity.invitationEntity;

	@PersistenceContext
	private EntityManager entityManager;

	public boolean getInvitationStatusByNoteIdAndGuest(Long noteId, String guestEmail) {
		JPAQuery<InvitationEntity> query = new JPAQuery<InvitationEntity>(entityManager);
		return query.select(qInvitationEntity.status).from(qInvitationEntity)
				.where(qInvitationEntity.idNote.eq(noteId).and(qInvitationEntity.guest.eq(guestEmail))).fetchOne();
	}

	public List<InvitationEntity> getPendingInvitationsToNotesByGuest(String guestEmail) {
		JPAQuery<InvitationEntity> query = new JPAQuery<InvitationEntity>(entityManager);
		return (List<InvitationEntity>) query.from(qInvitationEntity)
				.where(qInvitationEntity.guest.eq(guestEmail).and(qInvitationEntity.status.isFalse())).fetch();
	}

	public List<String> getAllGuestsByNoteIdAndHost(Long noteId, String hostEmail) {
		JPAQuery<InvitationEntity> query = new JPAQuery<InvitationEntity>(entityManager);
		return query.select(qInvitationEntity.guest).from(qInvitationEntity)
				.where(qInvitationEntity.idNote.eq(noteId).and(qInvitationEntity.host.eq(hostEmail))).fetch();
	}

	public InvitationEntity getInvitationByNoteIdAndGuestEmail(Long noteId, String guestEmail) {
		JPAQuery<InvitationEntity> query = new JPAQuery<InvitationEntity>(entityManager);
		return query.from(qInvitationEntity).where(qInvitationEntity.idNote.eq(noteId).and(qInvitationEntity.guest.eq(guestEmail))).fetchOne();
	}

	public List<InvitationEntity> allInvitationToNotesByEmailGuest(String emailGuest) {
		JPAQuery<InvitationEntity> query = new JPAQuery<InvitationEntity>(entityManager);
		return query.from(qInvitationEntity).where(qInvitationEntity.guest.eq(emailGuest).and(qInvitationEntity.status.isTrue())).fetch();
	}

}
