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
    private Registry registry;
    private ReadLocalGson read;
    private Patient patient = new Patient("Palina", "Manenok", "10-11-1993", "true");

    @Before
    public void runBeforeTestMethod() {
        registry = new Registry();
        read = new ReadLocalGson(registry, new File(ReadLocalGsonTest.class.getClassLoader().getResource(testFile).getFile()));
    }

    @After
    public void runAfterTestMethod() {
        registry = null;
        read = null;
    }

    @Test
    public void checkRegistryContainsPatient() {
        read.operation();
        assertEquals(1, registry.getPatients().size());
        assertTrue(registry.getPatients().contains(patient));
    }
}
