package by.itacademy.lesson12.operable.serialization.json.serializers;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class PatientBooleanSerializer implements JsonSerializer<Boolean> {
    @Override
    public JsonElement serialize(Boolean src, Type typeOfSrc, JsonSerializationContext context) {
        String birth = src ? ("ill") : ("healthy");
        return new JsonPrimitive(birth);
    }
}
