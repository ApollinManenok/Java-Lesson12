package by.itacademy.lesson12.operable.serialization.json;

import by.itacademy.lesson12.domain.Registry;
import by.itacademy.lesson12.operable.serialization.UploadPatients;

public class UploadRemoteJackson extends UploadPatients {
    public UploadRemoteJackson(Registry registry, String source) {
        super(registry, source);
    }

    @Override
    public void operation() {

    }

    @Override
    public String typo() {
        return "Upload patients info from remote json file";
    }
}
