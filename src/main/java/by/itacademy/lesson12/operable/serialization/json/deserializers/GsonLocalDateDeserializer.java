package by.itacademy.lesson12.operable.serialization.json.deserializers;

import by.itacademy.lesson12.domain.PatientDateFormat;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.time.LocalDate;

public class GsonLocalDateDeserializer implements JsonDeserializer<LocalDate> {
    @Override
    public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String birthStr = json.getAsJsonPrimitive().getAsString();
        return LocalDate.parse(birthStr, PatientDateFormat.INSTANCE.format());
    }
}
