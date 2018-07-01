package by.itacademy.lesson12.operable.serialization.json.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class JcsonBooleanDeserializer extends StdDeserializer<Boolean> {
    public JcsonBooleanDeserializer() {
        super(Boolean.class);
    }

    @Override
    public Boolean deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        String statusStr = jp.getValueAsString();
        Boolean status = null;
        if (statusStr.equalsIgnoreCase("HEALTHY") || statusStr.equalsIgnoreCase("ILL"))
            status = statusStr.equalsIgnoreCase("HEALTHY");
        return status;
    }
}
