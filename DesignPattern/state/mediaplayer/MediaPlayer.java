package state.mediaplayer;

public class MediaPlayer {

    private MediaPlayerState mediaPlayerState = new StoppedState();

    public MediaPlayerState getMediaPlayerState() {
        return mediaPlayerState;
    }

    public void setMediaPlayerState(MediaPlayerState mediaPlayerState) {
        this.mediaPlayerState = mediaPlayerState;
    }

    public void play(){
        mediaPlayerState.play(this);
    }

    public void pause(){
        mediaPlayerState.pause(this);
    }

    public void stop(){
        mediaPlayerState.stop(this);
    }
}
