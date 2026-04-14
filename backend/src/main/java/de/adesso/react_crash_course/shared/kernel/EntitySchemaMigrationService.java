package de.adesso.react_crash_course.shared.kernel;

public interface EntitySchemaMigrationService<T> {

    boolean isMigrationRequired(T entity);

    T migrate(T entity);
}
