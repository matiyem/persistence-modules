package jpa.data.ConverterAnnotation;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
//لازم به ذکر این attribute با @Enumerated نمیتواند استفاده شود
public class GenderConverter implements AttributeConverter<Gender, Character> {
    @Override
    public Character convertToDatabaseColumn(Gender gender) {
        if ( gender == null ) {
            return null;
        }

        return gender.getCode();
    }

    @Override
    public Gender convertToEntityAttribute(Character character) {
        if ( character == null ) {
            return null;
        }

        return Gender.fromCode( character );
    }
}
