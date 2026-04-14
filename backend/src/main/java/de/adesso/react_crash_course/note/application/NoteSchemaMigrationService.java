package de.adesso.react_crash_course.note.application;

import java.util.List;

import org.springframework.stereotype.Service;

import de.adesso.react_crash_course.note.domain.Note;
import de.adesso.react_crash_course.note.persistence.NoteRepository;
import de.adesso.react_crash_course.shared.kernel.EntityMigrationService;

@Service
public class NoteSchemaMigrationService implements EntityMigrationService<Note> {

    private final NoteRepository noteRepository;

    public NoteSchemaMigrationService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public boolean isMigrationRequired(Note note) {
        return note.getSchemaVersion() < Note.CURRENT_SCHEMA_VERSION;
    }

    @Override
    public Note migrate(Note note) {
        var schemaVersion = note.getSchemaVersion();

        if (schemaVersion == 0) {
            note = Note.builder()
                    .id(note.getId())
                    .note(note.getNote())
                    .schemaVersion(1)
                    .categories(List.of())
                    .build();
        }

        return noteRepository.save(note);
    }
}
