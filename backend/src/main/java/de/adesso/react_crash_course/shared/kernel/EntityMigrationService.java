package de.adesso.react_crash_course.shared.kernel;

public interface EntityMigrationService<T> {

    boolean isMigrationRequired(T entity);

    T migrate(T entity);
}
