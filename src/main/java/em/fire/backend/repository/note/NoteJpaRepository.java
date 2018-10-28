package em.fire.backend.repository.note;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import em.fire.backend.entity.note.NoteEntity;

@Repository("noteJpaRepository")
public interface NoteJpaRepository extends JpaRepository<NoteEntity, Serializable> {

}
