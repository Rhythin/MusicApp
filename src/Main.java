import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Album album1=new Album("Bad 25", "Michael Jackson");
        album1.addSongToAlbum("Bad", 4.07);
        album1.addSongToAlbum("The way you make me feel", 4.58);
        album1.addSongToAlbum("Smooth criminal", 4.18);

        Album album2=new Album("Thriller", "Michael Jackson");
        album2.addSongToAlbum("Thriller", 5.58);
        album2.addSongToAlbum("Billie Jean", 4.54);
        album2.addSongToAlbum("Beat it", 4.18);

        LinkedList<Song> playList=new LinkedList<>();
        album1.addToPlaylistFromAlbum(2, playList);
        album1.addToPlaylistFromAlbum("Smooth criminal", playList);
        album2.addToPlaylistFromAlbum("Billie Jean", playList);
        album2.addToPlaylistFromAlbum(3,playList);

        play(playList);
    }


    public static void play(LinkedList<Song> playlist){
        ListIterator<Song> itr= playlist.listIterator();
        Scanner sc=new Scanner(System.in);
        boolean isForward=true;

        if(playlist.size()>0){
            System.out.println(itr.next());
        }
        else {
            System.out.println("playlist is empty");
            return;
        }

        System.out.println("Select your choice");
        printMenu();

        boolean quit=false;

        while(!quit){
            int choice=sc.nextInt();

            switch (choice){
                case 1://play next song
                    if(!isForward){
                        itr.next();
                        isForward=true;
                    }
                    if(itr.hasNext()){
                        System.out.println(itr.next());
                    }
                    else {
                        System.out.println("you have reached end of playlist");
                        isForward=false;
                    }
                    break;
                case 2://play previous song
                    if(isForward){
                        itr.previous();
                        isForward=false;
                    }
                    if(itr.hasPrevious()){
                        System.out.println(itr.previous());
                    }
                    else {
                        System.out.println("you are at beginning of playlist");
                        isForward=true;
                    }
                    break;
                case 3://repeat current song
                    if(isForward){
                        if(itr.hasPrevious()){
                            System.out.println(itr.previous());
                            isForward=false;
                        }
                        else {
                            System.out.println("song doesn't exist");
                        }

                    }
                    else{
                        if(itr.hasNext()){
                            System.out.println(itr.next());
                            isForward=true;
                        }
                        else {
                            System.out.println("song doesn't exist");
                        }

                    }
                    break;
                case 4: ///print menu again
                    printMenu();
                    break;
                case 5://delete current song
                    break;
                case 6:
                    quit=true;
                    break;
            }
        }


    }

    public static void printMenu(){
        System.out.println("Select your choice");
        System.out.println("1: Play next song");
        System.out.println("2: previous song");
        System.out.println("3: repeat current song");
        System.out.println("4: Show menu again");
        System.out.println("5: delete current song");
        System.out.println("6: quit");
        System.out.println();
    }


}