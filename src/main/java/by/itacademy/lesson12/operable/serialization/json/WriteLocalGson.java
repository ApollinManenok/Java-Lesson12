package by.itacademy.lesson12.operable.serialization.json;

import by.itacademy.lesson12.domain.Patient;
import by.itacademy.lesson12.domain.Registry;
import by.itacademy.lesson12.operable.serialization.WritePatients;
import by.itacademy.lesson12.operable.serialization.json.serializers.PatientBooleanSerializer;
import by.itacademy.lesson12.operable.serialization.json.serializers.PatientLocalDateSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;

public class WriteLocalGson extends WritePatients {
    public WriteLocalGson(Registry registry, String source) {
        super(registry, source);
    }

    @Override
    public void operation() {
        Registry registry = getRegistry();
        registry.addPatient(new Patient("Palina", "Manenok", "10-11-1993", "false"));
        registry.addPatient(new Patient("Polina", "Manenok", "09-03-1993", "true"));
        try (Writer writer = new FileWriter(getSource())) {
            GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(LocalDate.class, new PatientLocalDateSerializer());
            gsonBuilder.registerTypeAdapter(Boolean.class, new PatientBooleanSerializer());
            Gson gson = gsonBuilder.create();
            gson.toJson(registry, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String typo() {
        return "Write patients info into local json file";
    }
}
