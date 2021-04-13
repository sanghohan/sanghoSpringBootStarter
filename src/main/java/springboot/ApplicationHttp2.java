package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ApplicationHttp2 {

    @RequestMapping("/test")
    public String test() {
        return "Hello http2 protocol";
    }

    public static void main (String [] args) {

       // SpringApplication.run(ApplicationHttp2.class);
        new SpringApplicationBuilder()
                .listeners(new SampleListener())
                .sources(ApplicationHttp2.class)
                .run(args);
    }
}
