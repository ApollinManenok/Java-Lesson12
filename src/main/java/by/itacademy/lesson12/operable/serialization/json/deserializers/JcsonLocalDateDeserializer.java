package by.itacademy.lesson12.operable.serialization.json.deserializers;

import by.itacademy.lesson12.domain.PatientDateFormat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;

public class JcsonLocalDateDeserializer extends StdDeserializer<LocalDate> {
    public JcsonLocalDateDeserializer() {
        super(LocalDate.class);
    }

    @Override
    public LocalDate deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String birth = jp.getValueAsString();
        return LocalDate.parse(birth, PatientDateFormat.INSTANCE.format());
    }

}
