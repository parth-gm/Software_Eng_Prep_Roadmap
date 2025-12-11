package Bridge;

public class TV implements Device{
    int volume;
    boolean isOn = false;
    @Override
    public boolean isEnabled() {
        return this.isOn;
    }

    @Override
    public int getVolume() {
        return this.volume;
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
    }
}
