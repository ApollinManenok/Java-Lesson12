package by.itacademy.lesson12.operable.serialization.json.deserializers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class GsonBooleanDeserializer implements JsonDeserializer<Boolean> {
    @Override
    public Boolean deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String statusStr = json.getAsJsonPrimitive().getAsString();
        Boolean status = null;
        if (statusStr.equalsIgnoreCase("HEALTHY") || statusStr.equalsIgnoreCase("ILL"))
            status = statusStr.equalsIgnoreCase("HEALTHY");
        return status;
    }
}

