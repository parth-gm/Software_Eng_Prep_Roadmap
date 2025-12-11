package chainOfResponsibility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainDemo {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Server server = new Server();

        Middleware middleware = Middleware.link(new ThrottlingMiddleware(100),
                new UserExistMiddleWare(),
                new RoleCheckMiddleWare());
        server.setMiddleware(middleware);

        boolean success;
        do {
            System.out.print("Enter email: ");
            String email = reader.readLine();
            System.out.print("Input password: ");
            String password = reader.readLine();
            success = server.logIn(email, password);
        } while (!success);
    }
}
