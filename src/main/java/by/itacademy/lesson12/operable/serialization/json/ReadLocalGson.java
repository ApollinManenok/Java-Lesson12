package by.itacademy.lesson12.operable.serialization.json;

import by.itacademy.lesson12.ExceptionHandler;
import by.itacademy.lesson12.domain.Registry;
import by.itacademy.lesson12.operable.serialization.ReadPatients;
import by.itacademy.lesson12.operable.serialization.json.deserializers.GsonBooleanDeserializer;
import by.itacademy.lesson12.operable.serialization.json.deserializers.GsonLocalDateDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadLocalGson extends ReadPatients {
    public ReadLocalGson(Registry registry, String source) {
        super(registry, source);
    }

    public ReadLocalGson(Registry registry, File file) {
        super(registry, file);
    }

    @Override
    public void operation() {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new GsonLocalDateDeserializer())
                .registerTypeAdapter(Boolean.class, new GsonBooleanDeserializer())
                .registerTypeAdapter(boolean.class, new GsonBooleanDeserializer()).create();
        try (JsonReader reader = new JsonReader(new FileReader(getFile()))) {
            Registry temp = gson.fromJson(reader, Registry.class);
            getRegistry().addAll(temp.getPatients());
        } catch (IOException e) {
            new ExceptionHandler().handle(Level.SEVERE, e.getMessage(), e);
        }
    }

    @Override
    public String typo() {
        return "Read patients info from local json file";
    }
}
