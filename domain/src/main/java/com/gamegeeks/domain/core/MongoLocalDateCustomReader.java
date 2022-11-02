package com.gamegeeks.domain.core;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

public class MongoLocalDateCustomReader implements Converter<Date, LocalDate> {

    @Override
    public LocalDate convert(Date source) {
        return source.toInstant().atZone(ZoneOffset.UTC).toLocalDate();
    }
}
