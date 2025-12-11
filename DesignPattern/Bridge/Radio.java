package Bridge;

// TO DO (Only for example)
public class Radio implements Device{
    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public int getVolume() {
        return 0;
    }

    @Override
    public void setVolume(int volume) {
        // TO DO
    }
}
