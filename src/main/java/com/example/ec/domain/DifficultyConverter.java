package com.example.ec.domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class DifficultyConverter implements AttributeConverter<Difficulty, String>{

    @Override
    public String convertToDatabaseColumn(Difficulty attribute) {
        return attribute.name();
    }

    @Override
    public Difficulty convertToEntityAttribute(String dbData) {
        return Difficulty.valueOf(dbData);
    }
    
}
