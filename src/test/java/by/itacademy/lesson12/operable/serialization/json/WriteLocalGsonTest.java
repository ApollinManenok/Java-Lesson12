package by.itacademy.lesson12.operable.serialization.json;

import by.itacademy.lesson12.domain.Patient;
import by.itacademy.lesson12.domain.Registry;
import org.junit.After;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WriteLocalGsonTest {
    private Registry registry = new Registry();
    private String testFile = "WriteLocalGsonTestRegistry.json";
    private File file = new File(ReadLocalGsonTest.class.getClassLoader().getResource("WriteLocalGsonTestRegistry.json").getFile());
    private WriteLocalGson write = new WriteLocalGson(registry, file);
    private ReadLocalGson read = new ReadLocalGson(registry, file);
    private Patient patient1 = new Patient("Elvis", "Presley", "8-1-1935", "true");
    private Patient patient2 = new Patient("Louis", "Armstrong", "4-8-1901", "false");

    @Test
    public void checkWritingPatients() {
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
