package by.itacademy.lesson12.operable.serialization.json;

import by.itacademy.lesson12.domain.Patient;
import by.itacademy.lesson12.domain.Registry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ReadLocalGsonTest {
    private String testFile = "ReadLocalGsonTestRegistry.json";
    private Registry registry = new Registry();
    private ReadLocalGson read = new ReadLocalGson(registry, new File(ReadLocalGsonTest.class.getClassLoader().getResource(testFile).getFile()));
    private Patient patient = new Patient("Louis", "Armstrong", "4-8-1901", "false");

    @Test
    public void checkReadingPatients() {
        read.operation();
        assertEquals(2, registry.getPatients().size());
        assertTrue(registry.getPatients().contains(patient));
    }
}
