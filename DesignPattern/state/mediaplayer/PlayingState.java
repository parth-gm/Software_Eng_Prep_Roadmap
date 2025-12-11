package state.mediaplayer;

public class PlayingState implements MediaPlayerState{
    public void play(MediaPlayer p) { System.out.println("Already playing."); }

    public void pause(MediaPlayer p) {
        System.out.println("Paused.");
        p.setMediaPlayerState(new PauseState());
    }

    public void stop(MediaPlayer p) {
        System.out.println("Stopped.");
        p.setMediaPlayerState(new StoppedState());
    }
}
