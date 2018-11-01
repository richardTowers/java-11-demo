import io.javalin.Javalin;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

public class HelloInternet {
    public static void main(String[] args) {
        var port = Optional.ofNullable(System.getenv("PORT")).map(Integer::parseInt).orElse(7000);
        final var app = Javalin.create().start(port);
        app.get("/", (final var ctx) -> {
            if (canUseNewHttpClient()) {
                ctx.result("Hello from the fancy new world of java 11");
            } else {
                ctx.result("It's java 11, but it's not working properly :scream:");
            }
        });
    }

    private static boolean canUseNewHttpClient() {
        final var client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
        final var request = HttpRequest.newBuilder().uri(URI.create("https://http2.github.io")).GET().build();
        try {
            final var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            return false;
        }
        return true;
    }
}
