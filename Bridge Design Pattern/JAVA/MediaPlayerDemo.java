// Implementation Layer
interface PlaybackEngine {
    void play(String mediaFile);
}

// Abstraction Layer
interface MediaPlayer {
    void playMedia(String mediaFile);
}

// Concrete Abstraction: MusicPlayer
class MusicPlayer implements MediaPlayer {
    private String playerName;
    private PlaybackEngine playbackEngine;

    public MusicPlayer(String playerName) {
        this.playerName = playerName;
    }

    public void setPlaybackEngine(PlaybackEngine engine) {
        this.playbackEngine = engine;
    }

    public void playMedia(String mediaFile) {
        System.out.print("MusicPlayer '" + playerName + "' playing " + mediaFile + " using ");
        playbackEngine.play(mediaFile);
    }
}

// Concrete Abstraction: VideoPlayer
class VideoPlayer implements MediaPlayer {
    private String playerName;
    private PlaybackEngine playbackEngine;

    public VideoPlayer(String playerName) {
        this.playerName = playerName;
    }

    public void setPlaybackEngine(PlaybackEngine engine) {
        this.playbackEngine = engine;
    }

    public void playMedia(String mediaFile) {
        System.out.print("VideoPlayer '" + playerName + "' playing " + mediaFile + " using ");
        playbackEngine.play(mediaFile);
    }
}

// Concrete Implementation: VLC
class VLC implements PlaybackEngine {
    public void play(String mediaFile) {
        System.out.println("VLC player.");
        // Actual VLC playback logic
    }
}

// Concrete Implementation: WindowsMediaPlayer
class WindowsMediaPlayer implements PlaybackEngine {
    public void play(String mediaFile) {
        System.out.println("Windows Media Player.");
        // Actual Windows Media Player playback logic
    }
}

class MediaPlayerDemo {
    public static void main(String[] args) {
        // Create a MusicPlayer and a VideoPlayer
        MusicPlayer musicPlayer = new MusicPlayer("Sony");
        VideoPlayer videoPlayer = new VideoPlayer("LG");

        // Create different playback engines
        VLC vlc = new VLC();
        WindowsMediaPlayer windowsMediaPlayer = new WindowsMediaPlayer();

        // Set the playback engine for MusicPlayer
        musicPlayer.setPlaybackEngine(vlc);

        // Play media using MusicPlayer with VLC engine
        musicPlayer.playMedia("MyFavoriteSong.mp3");

        // Switch to Windows Media Player for VideoPlayer
        videoPlayer.setPlaybackEngine(windowsMediaPlayer);

        // Play media using VideoPlayer with Windows Media Player engine
        videoPlayer.playMedia("MyFavoriteMovie.mp4");
    }
}
