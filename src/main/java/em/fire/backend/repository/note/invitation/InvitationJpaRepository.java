package em.fire.backend.repository.note.invitation;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import em.fire.backend.entity.note.invitation.InvitationEntity;

@Repository("invitationJpaRepository")
public interface InvitationJpaRepository  extends JpaRepository<InvitationEntity, Serializable>  {

}
