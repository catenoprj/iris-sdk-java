package br.com.cateno.sdk.infra;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimeSerializer extends JsonSerializer<ZonedDateTime> {

  private final DateTimeFormatter formatter;

  public ZonedDateTimeSerializer(final DateTimeFormatter formatter) {
    this.formatter = formatter;
  }

  @Override
  public void serialize(final ZonedDateTime value, final JsonGenerator generator, final SerializerProvider serializers) throws IOException {
    generator.writeString(value.format(this.formatter));
  }
}
