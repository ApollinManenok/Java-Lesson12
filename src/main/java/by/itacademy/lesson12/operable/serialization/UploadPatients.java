package by.itacademy.lesson12.operable.serialization;

import by.itacademy.lesson12.ExceptionHandler;
import by.itacademy.lesson12.domain.Registry;
import by.itacademy.lesson12.operable.BaseRegistryOperation;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

public abstract class UploadPatients extends BaseRegistryOperation {
    private String source;
    private URL url;

    public UploadPatients(Registry registry, String source) {
        super(registry);
        try {
            this.source = source;
            this.url = new URL(this.source);
        } catch (MalformedURLException e) {
            new ExceptionHandler().handle(Level.SEVERE, "Can't get url from " + this.source, e);
        }
    }

    public UploadPatients(Registry registry, URL url) {
        super(registry);
        this.url = url;
    }

    public String getSource() {
        return source;
    }

    public URL getUrl() {
        return url;
    }
}
