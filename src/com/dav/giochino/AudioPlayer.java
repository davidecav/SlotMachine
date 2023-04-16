package com.dav.giochino;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class AudioPlayer {
	
	String audioFilePath = "./audio/synth.mp3";
	
	
	
	public void update() {
		try {
            FileInputStream fileInputStream = new FileInputStream(new File(audioFilePath));
            Player player = new Player(fileInputStream);

            System.out.println("Riproduzione iniziata!");

            player.play();


            System.out.println("Riproduzione terminata!");
            

        } catch (JavaLayerException | IOException e) {
            System.out.println("file non esistente");
        }	
		
	}
	
	
} 

/*
		//metodo con AudioInputStream
  			private static final int BUFFER_SIZE = 4096;

	InputStream inputStream = getClass().getClassLoader().getResourceAsStream(audioFilePath);

	
		public void update() {
		
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(inputStream);
			
			AudioFormat audioFormat = audioStream.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);
			SourceDataLine sourceDataLine = (SourceDataLine) AudioSystem.getLine(info);
			sourceDataLine.open(audioFormat);
			sourceDataLine.start();
			
			byte[] bufferBytes = new byte[BUFFER_SIZE];
			int readBytes = -1;
			while ((readBytes = audioStream.read(bufferBytes)) != -1) {
			    sourceDataLine.write(bufferBytes, 0, readBytes);
			}
			
			sourceDataLine.drain();
			sourceDataLine.close();
			audioStream.close();
			
		
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			System.out.println("file non trovato");
			
		}
		
	}
	
	*/
	/*
	boolean isPlaybackCompleted;

	
	InputStream inputStream= getClass().getClassLoader().getResourceAsStream(audioFilePath);
	AudioInputStream audioStream=getAudioStream(inputStream);
	
	AudioFormat audioFormat = audioStream.getFormat();
	DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
	
	Clip audioClip;
	
	
	
	//metodo con CLIP
	
    @Override
    public void update(LineEvent event) {
        if (LineEvent.Type.START == event.getType()) {
        	
            System.out.println("è iniziato il play.");
            try {
            	audioClip= (Clip) AudioSystem.getLine(info);
            	audioClip.addLineListener(this);
				audioClip.open(audioStream);
				audioClip.start();
				audioClip.loop(Clip.LOOP_CONTINUOUSLY);
			} catch (LineUnavailableException | IOException e) {
				e.printStackTrace();
			}
        } else if (LineEvent.Type.STOP == event.getType()) {
            isPlaybackCompleted = true;
            System.out.println("play terminato.");
            try {
            	audioClip.close();
				audioStream.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
            
        }
    }

	public AudioInputStream getAudioStream(InputStream inputStream) {
		try {
			return AudioSystem.getAudioInputStream(inputStream);
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	*/



/*
public static Map<String, Sound > soundMap = new HashMap<String, Sound>();

public static Map<String, Music> musicMap = new HashMap<String, Music>();

	private File directory;
	private int songNumber;
	private boolean running;
	private List<File> songs;
	private File[] files ;
	private Media media;
	public AudioPlayer() {
		running =false;
		songs = new ArrayList<File>();
		directory = new File("music");
		files = directory.listFiles();
		if(files!=null) {
			for(File file : files) {
				songs.add(file);
				System.out.println(file);
			}
		}
		media = new Media(songs.get(songNumber).toURI().toString());
		
	}
 */