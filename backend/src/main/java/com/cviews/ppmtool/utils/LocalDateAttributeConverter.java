package com.cviews.ppmtool.utils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDateTime, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDateTime localDateTime) {
        return localDateTime == null ? null : Date.valueOf(localDateTime.toLocalDate());
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Date sqlDate) {
        return sqlDate == null ? null : LocalDateTime.ofInstant(sqlDate.toInstant(), ZoneId.systemDefault());
    }
}
