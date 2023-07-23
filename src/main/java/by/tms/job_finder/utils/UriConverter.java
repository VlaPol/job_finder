package by.tms.job_finder.utils;

import jakarta.persistence.AttributeConverter;

import java.net.URI;

public class UriConverter implements AttributeConverter<URI, String> {
    @Override
    public String convertToDatabaseColumn(URI uri) {

        return uri == null ? null : uri.toString();
    }

    @Override
    public URI convertToEntityAttribute(String dbColumn) {

        return dbColumn == null ? null : URI.create(dbColumn);
    }
}
