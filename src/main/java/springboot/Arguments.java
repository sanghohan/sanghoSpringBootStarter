package springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Order(0)
//public class Arguments
public class Arguments implements ApplicationRunner {
//public class Arguments implements CommandLineRunner {
  /*  @Override
    public void run(String... args) throws Exception {
        //Arrays.stream(args).collect().toString();

    }*/

    @Value("holoman.name")
    private String name;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("name : " + name);
        System.out.println("argument foo : " + args.containsOption("foo"));

    }

   /* public Arguments(ApplicationArguments args) {
        System.out.println("argument foo : " + arguments.containsOption("foo"));
    }*/

}
