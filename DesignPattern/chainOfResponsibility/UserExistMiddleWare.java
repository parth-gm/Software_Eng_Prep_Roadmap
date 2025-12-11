package chainOfResponsibility;

public class UserExistMiddleWare extends Middleware{
//    Database db;

    @Override
    public boolean check(String email, String password) {
        return this.nextMiddleware.check(email, password); // for example -> It checks in db
    }
}
