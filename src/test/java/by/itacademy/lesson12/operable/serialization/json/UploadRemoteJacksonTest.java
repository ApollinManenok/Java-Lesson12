package by.itacademy.lesson12;

import by.itacademy.lesson12.domain.Patient;
import by.itacademy.lesson12.domain.Registry;
import by.itacademy.lesson12.operable.serialization.json.UploadRemoteJackson;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class JsonUploadTest {
    private Registry registry = new Registry();
    private UploadRemoteJackson upload = new UploadRemoteJackson(registry, "https://raw.githubusercontent.com/PManenok/Java-Lesson12-Text/master/Registry.json");

    @Test
    public void checkUploadingPatients() {
        upload.operation();
        assertTrue(!registry.getPatients().isEmpty());
        assertTrue(registry.getPatients().contains(new Patient("Elvis", "Presley", "8-1-1935", "true")));
    }
}
