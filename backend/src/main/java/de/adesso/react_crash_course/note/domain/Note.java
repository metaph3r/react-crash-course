package de.adesso.react_crash_course.note.domain;

import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "notes")
public class Note {

    public static final int CURRENT_SCHEMA_VERSION = 1;

    @Id
    private final UUID id;

    private int schemaVersion;
    private final String note;
    private final List<Category> categories;

    public static Note create(String text) {
        var note = new Note(UUID.randomUUID(), text, List.of());
        note.setSchemaVersion(CURRENT_SCHEMA_VERSION);
        return note;
    }
}
