package com.gamegeeks.domain.core;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

public class MongoLocalDateCustomWriter implements Converter<LocalDate, Date> {

    @Override
    public Date convert(LocalDate source) {
        return new Date(source.atStartOfDay().atZone(ZoneOffset.UTC).toInstant().toEpochMilli());
    }
}
