package by.itacademy.lesson12.operable.serialization.json;

import by.itacademy.lesson12.ExceptionHandler;
import by.itacademy.lesson12.domain.Registry;
import by.itacademy.lesson12.operable.serialization.UploadPatients;
import by.itacademy.lesson12.operable.serialization.json.deserializers.JcsonBooleanDeserializer;
import by.itacademy.lesson12.operable.serialization.json.deserializers.JcsonLocalDateDeserializer;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;

public class UploadRemoteJackson extends UploadPatients {
    public UploadRemoteJackson(Registry registry, String source) {
        super(registry, source);
    }

    @Override
    public void operation() {
        try {
            Registry temp = new ObjectMapper()
                    .registerModule(new SimpleModule().addDeserializer(LocalDate.class, new JcsonLocalDateDeserializer())
                            .addDeserializer(boolean.class, new JcsonBooleanDeserializer())
                            .addDeserializer(Boolean.class, new JcsonBooleanDeserializer()))
                    .readValue(getUrl(), Registry.class);
            getRegistry().addAll(temp.getPatients());
        } catch (IOException e) {
            new ExceptionHandler().handle(Level.SEVERE, e.getMessage(), e);
        }
    }

    @Override
    public String typo() {
        return "Upload patients info from remote json file";
    }
}
