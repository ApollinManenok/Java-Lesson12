package by.itacademy.lesson12;

import by.itacademy.lesson12.domain.Patient;
import by.itacademy.lesson12.domain.Registry;
import by.itacademy.lesson12.operable.serialization.json.ReadLocalGson;
import by.itacademy.lesson12.operable.serialization.json.WriteLocalGson;
import org.junit.After;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JsonWriteReadTest {
    private String testFile = "RegistryTest.json";
    private Registry registry = new Registry();
    private WriteLocalGson write = new WriteLocalGson(registry, testFile);
    private ReadLocalGson read = new ReadLocalGson(registry, testFile);
    private Patient patient1 = new Patient("Elvis", "Presley", "8-1-1935", "true");
    private Patient patient2 = new Patient("Louis", "Armstrong", "4-8-1901", "false");

    @After
    public void tearDown() {
        File file = new File(testFile);
        file.deleteOnExit();
    }

    @Test
    public void checkWritinReadingPatients() {
        registry.addPatient(patient1);
        registry.addPatient(patient2);
        write.operation();
        registry.getPatients().clear();
        assertTrue(registry.getPatients().isEmpty());
        read.operation();
        assertEquals(2, registry.getPatients().size());
        assertTrue(registry.getPatients().contains(patient1));
        assertTrue(registry.getPatients().contains(patient2));
    }
}
