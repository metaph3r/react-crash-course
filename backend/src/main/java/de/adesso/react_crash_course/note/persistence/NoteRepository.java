package de.adesso.react_crash_course.note.persistence;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import de.adesso.react_crash_course.note.domain.Note;

public interface NoteRepository extends MongoRepository<Note, UUID> {
}
