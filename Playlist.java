//Assignment #: Arizona State University Spring 2023 CSE205 #9
//Name: Abhiraam Gundu
//StudentID: 1224174705
//Lecture: T/Th 1:30pm
//Description: File for the Playlist class.

public class Playlist {
    String name;
    Song first;
    
    public Playlist(){
        name = "library";
        first = Song.END;
    }

    public Playlist(String name) {
        this.name = name;
        first = Song.END;
    }

    public String getName() {
        return name;
    }

    public void add(Song song){
    	//making sure that there are songs in the playlist.
    	if (first != Song.END) {
    		//Creates a song object that we will use to run through our linked list.
    		Song temp = first;
    		//Runs until there we reach the end of the playlist.
    		while (temp.next != Song.END) {
    			//if there is a song next, go to that song.
    			temp = temp.next;
    		}
    		//Once we finally reach the end, set the next song in the playlist as song.
    		temp.next = song;
    	} else {
    		//if there are no other songs in the list, set the song as the first song.
    		first = song;
    	}
    }

    public int size() {
    	//checking to see if there is a playlist.
    	if (first != Song.END) {
    		//starting at 1 because you can't have 1 song in a playlist and say you have 0 songs.
    		int size = 1;
    		//creates a temporary song object to run through our playlist.
    		Song temp = first;
    		//runs until we reach the end of playlist.
    		while (temp.next != Song.END) {
    			temp = temp.next;
    			//adds a value every time we go through a song.
    			size++;
    		}
    		//returns the size val.
    		return size;
    	}
    	//if there are no songs in the playlist, returns 0.
    	return 0;
    }

    public Song removeFirst() {
        //stores the first song in temp song.
    	Song temp = first;
    	//simply changes the first song to the song after it.
    	first = first.next;
    	//returns the temp variable.
    	return temp;
    }
 
    public int remove(Song song) {
    	//checking to see if there is any songs in the playlist.
    	if (first != Song.END) {
    		//creates temp song object.
    		Song temp = first;
    		//checks to see if the given song is the first song in the playlist.
    		if (first.equals(song)) {
    			//removes the first song in the list.
    			temp = this.removeFirst();
    			//returns the position of the song, which is 1.
    			return 1;
    		}
    		//runs through the entire song list until there are no more songs next.
    		while(temp.next != Song.END) {
    			//checks if the next song in the list equals the given song
    			if (temp.next.equals(song)) {
    				//skips the given song by changing the next value to the song after the given song.
    				temp.next = temp.next.next;
    				//returns the value of the song.
    				return getPosition(temp) + 1;
    			}
    			//checks the next song in the list.
    			temp = temp.next;	
    		}
    	}
    	//if no songs in the playlist, returns -1 as specified in instructions
    	return -1;
    }

    public Song head() {
        return first;
    }

    public int getPosition(Song song) {
        //checking to see if there are songs in the playlist.
    	if (first != Song.END) {
        	//creates a temp song object.
        	Song temp = first;
        	//Initializes the position to 0.
        	int value = 0;
        	//runs through the entire playlist.
        	while(temp != Song.END) {
        		//checks to see if a song is equal to a song in the playlist.
        		if (temp.equals(song)) {
        			//returns the value.
        			return value;
        		}
        		//increases the value each time we go to the next song.
        		value++;
        		//changes to next song.
        		temp = temp.next;
        	}
        }
    	//if no songs in playlist, returns -1.
    	return -1;
    }

    public String listSongs() {
        //creates empty string.
    	String list = "";
    	//checks to see if there are songs in the playlist.
    	if (first != Song.END) {
    		//creates temp song object.
        	Song temp = first;
        	//goes through entire playlist.
        	while (temp != Song.END) {
        		//adds the to string of each song to the list.
        		list = list + temp.toString() + "\n";
        		temp = temp.next;
        	}
        	//retunrs the list with total songs:"
        	return list + "\nTotal songs: " + this.size() + ".";
        }
    	//returns empty string if no songs in playlist.
    	return "";
    }
}
