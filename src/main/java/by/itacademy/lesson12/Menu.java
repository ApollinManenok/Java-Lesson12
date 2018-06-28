package by.itacademy.lesson12;

import by.itacademy.lesson12.domain.Registry;
import by.itacademy.lesson12.inputable.Insert;
import by.itacademy.lesson12.inputable.IntegerInput;
import by.itacademy.lesson12.operable.ConsoleAddPatient;
import by.itacademy.lesson12.operable.Operable;
import by.itacademy.lesson12.operable.PrintPatients;
import by.itacademy.lesson12.operable.serialization.json.ReadLocalGson;
import by.itacademy.lesson12.operable.serialization.json.UploadRemoteJackson;
import by.itacademy.lesson12.operable.serialization.json.WriteLocalGson;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu {
    private static final Logger LOGGER = Logger.getLogger(Menu.class.getName());
    private ArrayList<Operable> operations = new ArrayList<>();
    private Registry registry = new Registry();

    {
        operations.add(new PrintPatients(registry));
        operations.add(new ConsoleAddPatient(registry));
        operations.add(new ReadLocalGson(registry, "Registry.json")); //Read Local
        operations.add(new WriteLocalGson(registry, "Registry.json")); //Write Local
        operations.add(new UploadRemoteJackson(registry, "https://raw.githubusercontent.com/PManenok/Java-Lesson12-Text/master/Registry.json")); //Upload remote
    }

    public void list() {
        boolean term = true;
        while (term) {
            System.out.println("Registry menu:\n0. Exit");
            for (int i = 0; i < operations.size(); i++) {
                System.out.println((i + 1) + ". " + operations.get(i).typo());
            }
            try {
                int index = new Insert<>(new IntegerInput()).get("Enter option number");
                term = operate(index);
            } catch (InputMismatchException | RangeException e) {
                LOGGER.log(Level.WARNING, e.getMessage(), e);
            }
        }
    }

    private boolean operate(int index) throws RangeException {
        if (index < 0 || index > this.operations.size())
            throw new RangeException("Option out of list range");
        else if (index == 0)
            return false;
        index -= 1;
        operations.get(index).operation();
        return true;
    }
}
