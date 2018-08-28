package em.fire.backend.repository.user;

import em.fire.backend.entity.user.User;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository("userJpaRepository")
public interface UserJpaRepository extends JpaRepository<User, Serializable> {
    
}
