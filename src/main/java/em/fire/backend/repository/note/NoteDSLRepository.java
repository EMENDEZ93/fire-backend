package em.fire.backend.repository.note;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQuery;

import em.fire.backend.entity.note.Note;
import em.fire.backend.entity.note.QNote;

@Repository("noteDSLRepository")
public class NoteDSLRepository {

	private QNote qNote = QNote.note;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Note getNoteById(long id) {	
		JPAQuery<Note> query = new JPAQuery<Note>(entityManager);
		return query.select(qNote).from(qNote).where(qNote.Id.eq((long) id)).fetchOne();
	}

	public List<Note> getNotesByIdFirebase(String idFirebase) {	
		JPAQuery<Note> query = new JPAQuery<Note>(entityManager);
		return (List<Note>) query.from(qNote).where(qNote.idFirebase.eq(idFirebase)).fetch();
	}	
	
}
