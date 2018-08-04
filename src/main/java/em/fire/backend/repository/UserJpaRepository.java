package em.fire.backend.repository;

import em.fire.backend.entity.User;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository("userJpaRepository")
public interface UserJpaRepository extends JpaRepository<User, Serializable> {
    
}
