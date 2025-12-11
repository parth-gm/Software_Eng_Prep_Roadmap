package state.mediaplayer;

public class PauseState implements MediaPlayerState{
    @Override
    public void play(MediaPlayer player) {
        System.out.println("Resuming music....");
        player.setMediaPlayerState(new PlayingState());
    }

    @Override
    public void pause(MediaPlayer player) {
        System.out.println("Already paused");
    }

    @Override
    public void stop(MediaPlayer player) {
        System.out.println("Stopped");
        player.setMediaPlayerState(new StoppedState());
    }
}
