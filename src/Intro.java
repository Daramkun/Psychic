import javax.microedition.lcdui.*;
import java.io.DataInputStream;
import com.xce.io.*;

//
// 인트로 클래스 - Press any key
//
public class Intro extends Define
{
	MainCanvas mc;
	Image main;
	Image pak;
	byte count;
	boolean blank;
//	====================================================================================	 
	private byte nState;
	
	final String VERSION = "v1.0.3";
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// 생성자 
	public Intro(MainCanvas mc)
	{
		this.mc = mc;
		
		try
		{
			main = Image.createImage("etc/intro.png");
			pak = Image.createImage("etc/pak.png");
			
			if(!XFile.exists("option.dat"))
				return;
			
			FileInputStream is = new FileInputStream("option.dat");
			DataInputStream dis = new DataInputStream(is);
			
			Configs.sound = dis.readBoolean();
			Configs.deco = dis.readBoolean();
			
			dis.close();
			
			dis = null;
			is = null;
			
			System.gc();
		}
		catch(Exception ex)
		{
			
		}
	}
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	public void Start(Graphics g)
	{
		g.setColor(0x000000);
		g.fillRect(Configs.x, Configs.y, mc.nSXS, mc.nSYS);
		mc.InnerState(IN_LOOP);
	}
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	public void Key()
	{
		if(mc.KeyPress == 1)
		{
			nState = NEXT;
			mc.InnerState(IN_END);
			main = null;
			pak = null;
			
			System.gc();
		}
	}
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	public void Draw(Graphics g)
	{
		g.setColor(0xfefefe);

		try
		{
			g.drawImage(main, Configs.x, Configs.y, MainCanvas.G_TL);
			
			g.setColor(0xffffff);
			g.drawString(VERSION, Configs.x + 10, Configs.y + 160, MainCanvas.G_TL);

			if(count >= 5)
			{
				blank = !blank;
				count = 0;
			}
			
			if(blank)
				g.drawImage(pak, Configs.x + 40, Configs.y + 155, MainCanvas.G_TL);
		}
		catch(Exception ex)
		{ 
		}
		count ++;
	}
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	public void End(Graphics g)
	{
		switch(nState)
		{
		case NEXT:
			main = null;
			pak = null;
			System.gc();
			mc.GameState(LOGO);
			break;
		}
		mc.InnerState(IN_START);
	}
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
//	====================================================================================
}
