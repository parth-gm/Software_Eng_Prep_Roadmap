package state.mediaplayer;

public class StoppedState implements MediaPlayerState{

    public void play(MediaPlayer p) {
        System.out.println("Starting playback...");
        p.setMediaPlayerState(new PlayingState());
    }

    public void pause(MediaPlayer p) { System.out.println("Can't pause. Not playing."); }

    public void stop(MediaPlayer p) { System.out.println("Already stopped."); }
}
