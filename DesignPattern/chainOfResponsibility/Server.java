package chainOfResponsibility;

public class Server {
    private Middleware middleware;
    public void setMiddleware(Middleware middleware) {
        this.middleware = middleware;
    }

    public boolean logIn(String email, String password) {
        if (middleware.check(email, password)) {
            System.out.println("Authorization have been successful!");

            // Do something useful here for authorized users.
            return true;
        }
        return false;
    }


}
