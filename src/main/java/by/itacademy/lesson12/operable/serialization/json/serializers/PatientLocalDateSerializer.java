package by.itacademy.lesson12.operable.serialization.json.serializers;

import by.itacademy.lesson12.domain.PatientDateFormat;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.LocalDate;

public class PatientLocalDateSerializer implements JsonSerializer<LocalDate> {
    @Override
    public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
        String birth = src.format(PatientDateFormat.INSTANCE.format());
        return new JsonPrimitive(birth);
    }
}
