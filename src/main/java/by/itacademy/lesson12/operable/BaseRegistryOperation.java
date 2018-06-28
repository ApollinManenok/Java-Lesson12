package by.itacademy.lesson12.operable;

import by.itacademy.lesson12.domain.Registry;

public abstract class BaseRegistryOperation implements Operable {
    private Registry registry;

    public BaseRegistryOperation(Registry registry) {
        this.registry = registry;
    }

    public Registry getRegistry() {
        return registry;
    }
}
