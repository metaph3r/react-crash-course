package de.adesso.react_crash_course.note.application.mapper;

import de.adesso.react_crash_course.note.application.dto.CategoryDto;
import de.adesso.react_crash_course.note.domain.Category;

public class CategoryMapper {

    public static Category toEntity(CategoryDto categoryDto) {
        return new Category(categoryDto.getId(), categoryDto.getName());
    }

    public static CategoryDto toDto(Category category) {
        return new CategoryDto(category.getId(), category.getName());
    }
}
