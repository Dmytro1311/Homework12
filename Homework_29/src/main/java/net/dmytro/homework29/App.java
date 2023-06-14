package net.dmytro.homework29;

import net.dmytro.homework29.controller.OrderController;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/rest")
public class App extends Application {

    private final Set<Object> singletons = new HashSet<>();

    public App(){
        singletons.add(new OrderController());

    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
