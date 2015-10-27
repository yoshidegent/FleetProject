package com.realdolmen.fleet.converters;

import javax.persistence.AttributeConverter;
import java.sql.Date;
import java.time.LocalDate;

public class DateConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate attribute) {
        return Date.valueOf(attribute);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date dbData) {
        return dbData.toLocalDate();
    }
}
