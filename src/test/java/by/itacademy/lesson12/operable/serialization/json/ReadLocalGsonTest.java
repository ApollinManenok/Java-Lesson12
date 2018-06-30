package by.itacademy.lesson12.operable.serialization.json;

import by.itacademy.lesson12.domain.Patient;
import by.itacademy.lesson12.domain.Registry;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ReadLocalGsonTest {
    private String testFile = "ReadLocalGsonTestRegistry.json";
    private Registry registry = new Registry();
    private ReadLocalGson read = new ReadLocalGson(registry, testFile);
    private Patient patient = new Patient("Palina","Manenok","10-11-1993","true");

    @Test
    public void checkReadingPatients() {
        read.operation();
        assertEquals(1, registry.getPatients().size());
        assertTrue(registry.getPatients().contains(patient));
    }
}
