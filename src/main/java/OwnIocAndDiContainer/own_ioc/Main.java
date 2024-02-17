package OwnIocAndDiContainer.own_ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Phone bean = context.getBean(Phone.class);
        System.out.println(bean);
    }
}