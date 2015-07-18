import java.io.InputStream;

import com.skt.m.AudioClip;
import com.skt.m.AudioSystem;
import com.skt.m.UnsupportedFormatException;

//
// 사운드 플레이 클래스 - 팀 자작 클래스 아님 - 학교에서 일괄 지급
//
public class PlaySound extends Thread
{
	private AudioClip currentClip = null;

	private boolean bPlaying=false;
	
	private boolean bReady;
	private boolean bOn;
	
	private boolean bLoop;
	
	private final int VOLUME_LEVEL = 5;
	private int maxVolume;
	private int volumValue;
	
	public PlaySound(int maxSound)
	{
		
		bOn = true;
		
		try {
			maxVolume = AudioSystem.getMaxVolume("mmf");
			
		} catch (UnsupportedFormatException e) {
		}
		
		if(maxVolume > 0) {
			volumValue = maxVolume / VOLUME_LEVEL;
			
		}
		
		setVolume();
	}

	public void volUp()
	{
		try
		{
			int nextVolume = AudioSystem.getVolume("mmf") + volumValue;
			nextVolume = nextVolume > maxVolume ? maxVolume : nextVolume;
			
			AudioSystem.setVolume("mmf", nextVolume);
		} catch (Exception e) 
		{}
	}
	public void volDown()
	{
		try
		{
			int nextVolume = AudioSystem.getVolume("mmf") - volumValue;
			nextVolume = nextVolume < 0 ? 0 : nextVolume;
			
			AudioSystem.setVolume("mmf", nextVolume);
		} catch (Exception e) 
		{}
	}
	
	public int getVolume(){
		int volume = 0;
		try {
			volume = AudioSystem.getVolume("mmf");
		} catch (UnsupportedFormatException e) {
//			e.printStackTrace();
		}
		
		return volume;
	}
	
	public void setSoftVol()
	{
		try
		{
			AudioSystem.setVolume("mmf", 1);
		} catch (Exception e) 
		{}		
	}
	public void setVolume()
	{
		//최대로 초기화해 놓음
		try
		{
			currentClip = AudioSystem.getAudioClip("mmf");
//			if(volume >= 0)
//				AudioSystem.setVolume("mmf", volume);
//			AudioSystem.setVolume("mmf", AudioSystem.getMaxVolume("mmf")-1);
			
		}
		catch (Exception e) 
		{ }	
	}

	public synchronized void play(String path, boolean bLoop)
	{
//		System.out.println("SoundThread.play(String, boolean )");
		closeClip();
		
		waitForReady();
		
		try
		{
//			System.out.println("SoundThread.play() path: " + path);
			InputStream is = getClass().getResourceAsStream(path);
			byte[] sndtmp = new byte[is.available()];
			is.read( sndtmp, 0, is.available());
			is.close();

			if(Configs.sound)
				currentClip.open(sndtmp,0,sndtmp.length);
			
		} 
		catch(Exception e){
			////System.out.println("play "+path);
		}
//		currentIndex = -1;	//임시로 재생 하는 번호
		bPlaying = true;
		this.bLoop = bLoop;
		this.notify();
	}
	
	public void closeClip()
	{
		try
		{
			currentClip.close();
		} 
		catch(Exception e)
		{ }
	}
	
	private void waitForReady()
	{
		int count=0;
		try
		{		
			while(bReady==false)
			{	
				Thread.yield();
				
				count++;
				if(count>=10) break;
				
				//this.wait(100); 을 사용하면 안됨
				//sleep을 사용하면 안됨
			}
		} 
		catch(Exception e)
		{ }
	}

	public void run()
	{
		while (true) 
		{
			synchronized (this) 
			{
				bReady = true;
				try 
				{
					while (!bPlaying) 
					{						
						this.wait();
					}
				} 
				catch (Exception e)
				{ }
				bReady = false;
			}
			
			try 
			{
				if(bOn==true)
				{
					if(bLoop)
						currentClip.loop();
					else 
						currentClip.play();
				}
								
//				sndtmp = null;
				
				synchronized (this) 
				{
					bPlaying = false;
				}
			}
			catch (Exception e) 
			{
				bPlaying = false;
			}
			finally 
			{
				try 
				{
					currentClip.close();
				}
				catch (Exception e) 
				{ }
			}
		}
	}

	public void turnOn()
	{
		bOn = true;	
	}
	public void turnOff()
	{
		bOn = false;
	}

	/**
	 * @return
	 */
	public boolean isPlaying() {
		return bPlaying;
	}
}