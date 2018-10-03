package em.fire.backend.repository.friend;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import em.fire.backend.entity.friend.FriendEntity;

@Repository("friendJpaRepository")
public interface FriendJpaRepository extends JpaRepository<FriendEntity, Serializable> {

}
