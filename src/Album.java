import java.util.ArrayList;
import java.util.List;

public class Album {
    private String name;
    private String artist;

    private List<Song> songs;




    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public void addSongToAlbum(String name, double duration){
        Song s=new Song(name, duration);

        if(findsong(name)==true){
            System.out.println("song is already present");
        }
        else {
            songs.add(s);
        }
    }
    public boolean findsong(String title){
        for (Song s:songs){
            if(s.getTitle().equals(title))return true;
        }
        return false;
    }

    public boolean findsong(Song song){
        for (Song s:songs){
            if(s.getTitle().equals(song))return true;
        }
        return false;
    }

    public void addToPlaylistFromAlbum(String title, List<Song> playList){
        if(findsong(title)==true){
            for (Song s:songs){
                if(s.getTitle().equals(title)){
                    playList.add(s);
                    System.out.println("Song added to playlist");
                    break;
                }
            }
        }
        else {
            System.out.println("Song not available in album");
        }
    }

    public void addToPlaylistFromAlbum(int trackNo, List<Song> playList){
        int index=trackNo-1;

        if(index>0 && index<songs.size()){
            playList.add(songs.get(index));
        }
        else {
            System.out.println("Invalid Index");
        }
    }

}
