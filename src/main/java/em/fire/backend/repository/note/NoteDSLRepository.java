package em.fire.backend.repository.note;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQuery;

import em.fire.backend.entity.note.NoteEntity;
import em.fire.backend.entity.note.QNoteEntity;;

@Repository("noteDSLRepository")
public class NoteDSLRepository {

	private QNoteEntity qNote = QNoteEntity.noteEntity;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public NoteEntity getNoteById(long id) {	
		JPAQuery<NoteEntity> query = new JPAQuery<NoteEntity>(entityManager);
		return query.select(qNote).from(qNote).where(qNote.Id.eq((long) id)).fetchOne();
	}

	public List<NoteEntity> getNotesByIdFirebase(String idFirebase) {	
		JPAQuery<NoteEntity> query = new JPAQuery<NoteEntity>(entityManager);
		return (List<NoteEntity>) query.from(qNote).where(qNote.idFirebase.eq(idFirebase)).fetch();
	}	
	
}
