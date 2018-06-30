package by.itacademy.lesson12.operable.serialization.json;

import by.itacademy.lesson12.domain.Patient;
import by.itacademy.lesson12.domain.Registry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UploadRemoteJacksonTest {
    private Registry registry;
    private String source = "https://raw.githubusercontent.com/PManenok/Java-Lesson12-Text/master/Registry.json";
    private UploadRemoteJackson upload;

    @Before
    public void runBeforeTestMethod() {
        registry = new Registry();
        upload = new UploadRemoteJackson(registry, source);
    }

    @After
    public void runAfterTestMethod() {
        registry = null;
        upload = null;
    }

    @Test
    public void checkRegistryNotEmpty() {
        upload.operation();
        assertTrue(!registry.getPatients().isEmpty());
    }

    @Test
    public void checkRegistryContainsFourPatients() {
        upload.operation();
        assertEquals(4, registry.getPatients().size());
    }

    @Test
    public void checkRegistryContainsRightData() {
        upload.operation();
        assertTrue(registry.getPatients().contains(new Patient("Elvis", "Presley", "8-1-1935", "true")));
    }
}
