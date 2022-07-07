package com.woyo.toko.converter;

import com.woyo.toko.dto.CategoryDTO;
import com.woyo.toko.model.CategoryModel;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {
    public CategoryDTO convertToDTO(CategoryModel item) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryId(item.getCategoryId());
        categoryDTO.setCategoryName(item.getCategoryName());

        return categoryDTO;
    }
}
