package de.adesso.react_crash_course.note.application.mapper;

import de.adesso.react_crash_course.note.application.dto.CategoryDto;
import de.adesso.react_crash_course.note.domain.Category;

public class CategoryMapper {

    public static Category toEntity(CategoryDto categoryDto) {
        return Category.builder()
                .id(categoryDto.getId())
                .name(categoryDto.getName())
                .build();
    }

    public static CategoryDto toDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
