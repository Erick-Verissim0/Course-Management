package org.example;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
        String port = dotenv.get("PORT");

        if (port != null) {
            System.setProperty("server.PORT", port);
        }

        System.out.println("Server started on port " + port);

        SpringApplication.run(Main.class, args);
    }
}