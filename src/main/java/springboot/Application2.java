package springboot;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Application2 {
    public static void main (String [] args) throws LifecycleException {

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8090);

        Context context = tomcat.addContext("",null);

        HttpServlet servlet = new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

                PrintWriter writer = resp.getWriter();
                writer.println("<html><head><title>");
                writer.println("hey!! tomcat!!");
                writer.println("</title></head>");
                writer.print("<body><h1> hello tomcat </h1></body>");
                writer.print("</html>");

            }
        };
        String servletName = "tomcatServlet";
        tomcat.addServlet(context, servletName, servlet);
        context.addServletMappingDecoded("/*", servletName);


        tomcat.start();

        //tomcat.getServer().await();
    }
}
