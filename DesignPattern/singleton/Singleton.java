package singleton;

public class Singleton {

    private volatile Singleton instance;

//    public synchronized Helper getHelper()
//    public Singleton getInstance(){
//        if(instance==null)
//            return new Singleton();
//        return instance;
//    }


    public Singleton getInstance(){
        if(instance==null) {
            synchronized (this) {
                if (instance == null) {
                    return new Singleton();
                }
            }
        }
        return instance;
    }


}
