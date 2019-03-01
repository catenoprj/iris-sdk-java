package br.com.cateno.sdk.infra;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimeDeserializer extends JsonDeserializer<ZonedDateTime> {

  private final DateTimeFormatter formatter;

  public ZonedDateTimeDeserializer(final DateTimeFormatter formatter) {
    this.formatter = formatter;
  }

  @Override
  public ZonedDateTime deserialize(final JsonParser parser, final DeserializationContext context) throws IOException {
    return ZonedDateTime.parse(parser.getValueAsString(), this.formatter);
  }
}
