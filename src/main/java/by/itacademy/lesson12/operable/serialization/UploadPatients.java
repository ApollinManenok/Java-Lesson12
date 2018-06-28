package by.itacademy.lesson12.operable.serialization;

import by.itacademy.lesson12.domain.Registry;
import by.itacademy.lesson12.operable.BaseRegistryOperation;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class UploadPatients extends BaseRegistryOperation {
    private String source;
    private URL url;

    public UploadPatients(Registry registry, String source) {
        super(registry);
        try {
            this.source = source;
            this.url = new URL(this.source);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public String getSource() {
        return source;
    }

    public URL getUrl() {
        return url;
    }
}
