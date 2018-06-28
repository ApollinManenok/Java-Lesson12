package by.itacademy.lesson12.operable.serialization.json.deserializers;

import by.itacademy.lesson12.domain.PatientDateFormat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;

public class JcsonBooleanDeserializer extends StdDeserializer<Boolean> {

    public JcsonBooleanDeserializer() {
        super(Boolean.class);
    }

    @Override
    public Boolean deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String statusStr = jp.getValueAsString();
        Boolean status = null;
        if(statusStr.equalsIgnoreCase("HEALTHY") || statusStr.equalsIgnoreCase("ILL"))
            status = statusStr.equalsIgnoreCase("HEALTHY");
        return status;
    }
}
