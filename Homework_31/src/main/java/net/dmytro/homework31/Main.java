package net.dmytro.homework31;

import net.dmytro.homework31.config.AppConfig;
import net.dmytro.homework31.service.ConsoleShopping;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(AppConfig.class);
        annotationConfigApplicationContext.refresh();

        ConsoleShopping consoleShopping = annotationConfigApplicationContext.getBean(ConsoleShopping.class);
        consoleShopping.start();

        annotationConfigApplicationContext.close();
    }
}