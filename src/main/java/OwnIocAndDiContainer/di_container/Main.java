package OwnIocAndDiContainer.di_container;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ApplicationContext("di_container");
        Laptop laptop = new Laptop("DELL");
        Phone phone = new Phone("Nokia");
        context.registerBean(laptop);
        context.registerBean(phone);
        Map<String, Object> beans = context.getBeans();
        for (Map.Entry<String, Object> entry : beans.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }
    }
}
