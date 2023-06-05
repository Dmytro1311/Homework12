package net.dmytro.homework27;


import lombok.SneakyThrows;
import javax.xml.ws.Endpoint;

public class Main {

    private static final String ADDRES = "http://localhost:9999/basket?wsdl";
    private static final Object SERVICE = new Service();
    public static void main(String[] args) {
        Endpoint endpoint = Endpoint.publish(ADDRES, SERVICE);
        sleep();
        endpoint.stop();


    }
    @SneakyThrows
    public static void sleep(){
        while (true){
            Thread.sleep(100000);
        }
    }
}
