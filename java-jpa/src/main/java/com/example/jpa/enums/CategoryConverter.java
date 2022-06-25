package com.example.jpa.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

/*
    Create by Atiye Mousavi 
    Date: 6/18/2022
    Time: 3:07 PM
**/
@Converter(autoApply = true)
public class CategoryConverter implements AttributeConverter<Category,String> {
    @Override
    public String convertToDatabaseColumn(Category category) {
        if (category==null){
            return null;
        }
        return category.getCode();
    }

    @Override
    public Category convertToEntityAttribute(final String code) {
        if (code==null){
            return null;
        }
        return Stream.of(Category.values())
                .filter(c->c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
