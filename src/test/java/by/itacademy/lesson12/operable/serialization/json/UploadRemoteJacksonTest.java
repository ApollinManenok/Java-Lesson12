package by.itacademy.lesson12.operable.serialization.json;

import by.itacademy.lesson12.domain.Patient;
import by.itacademy.lesson12.domain.Registry;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UploadRemoteJacksonTest {
    private Registry registry = new Registry();
    private String source = "UploadRemoteJacksonTestRegistry.json";
    private UploadRemoteJackson upload = new UploadRemoteJackson(registry, UploadRemoteJacksonTest.class.getClassLoader().getResource(source));
    private Patient patient = new Patient("Elvis", "Presley", "8-1-1935", "true");

    @Test
    public void checkUploadingPatients() {
        upload.operation();
        assertEquals(4, registry.getPatients().size());
        assertTrue(registry.getPatients().contains(patient));
    }
}
