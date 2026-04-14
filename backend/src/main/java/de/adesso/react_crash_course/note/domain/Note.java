package de.adesso.react_crash_course.note.domain;

import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "notes")
public class Note {

    public static final int CURRENT_SCHEMA_VERSION = 1;

    @Id
    @Builder.Default
    private final UUID id = UUID.randomUUID();

    @Field
    @Builder.Default
    private final int schemaVersion = CURRENT_SCHEMA_VERSION;
    @Field
    private final String note;
    @DBRef
    @Builder.Default
    private final List<Category> categories = List.of();
}
