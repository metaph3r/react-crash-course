package de.adesso.react_crash_course.note.domain;

import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "notes")
public class Note {

    public static final int CURRENT_SCHEMA_VERSION = 1;

    @Id
    private final UUID id;

    @Field
    private final int schemaVersion;
    @Field
    private final String note;
    @Field
    private final List<Category> categories;

    public static Note create(String text) {
        return new Note(UUID.randomUUID(), CURRENT_SCHEMA_VERSION, text, List.of());
    }
}
