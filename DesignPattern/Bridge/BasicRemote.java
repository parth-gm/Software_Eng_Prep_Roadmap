package Bridge;

public class BasicRemote implements Remote{
    Device device;

    public BasicRemote(Device device) {
        this.device = device;
    }

    @Override
    public void power() {
        if(this.device.isEnabled()){
            // Add disable method in device and call it here;

        }
    }

    @Override
    public void volumeDown() {
        this.device.setVolume(this.device.getVolume()-10);
    }

    @Override
    public void volumeUp() {
        this.device.setVolume(this.device.getVolume()+10);
    }
}
