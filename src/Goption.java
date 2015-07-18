import javax.microedition.lcdui.*;
import java.io.DataOutputStream;
import com.xce.io.FileOutputStream;

//
// 옵션 클래스 - Gmenu에서 사용
//
public class Goption extends Define
{
	MainCanvas mc;
	Play play;
	Gmenu gm;
	Image menu;
	byte cursor;
	
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	public Goption(MainCanvas mc, Play play, Gmenu gm)
	{
		try
		{
			menu = Image.createImage("menu/menu4.png");
		}
		catch(Exception ex)
		{
			
		}
		
		this.mc = mc;
		this.play = play;
		this.gm = gm;
	}
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	public void Draw(Graphics g)
	{
		g.drawImage(menu,Configs.x,Configs.y,MainCanvas.G_TL);
		
		g.setColor(0x000000);
		g.fillRect(Configs.x + 35,Configs.y,150,180);
		g.setColor(240,240,240);
		g.drawString("<환경설정>", Configs.x + 50, Configs.x + 45, MainCanvas.G_TL);
		g.drawString("소리 : ON  OFF", Configs.x + 50, Configs.y + 57, MainCanvas.G_TL);
		g.drawString("장식물 : ON  OFF", Configs.x + 50, Configs.y + 77, MainCanvas.G_TL);
		g.setColor(0xff0000);

		if(cursor == 0)
			g.drawImage(Common.ocur, Configs.x + 40, Configs.y + 57, MainCanvas.G_TL);
		else
			g.drawImage(Common.ocur, Configs.x + 40, Configs.y + 77, MainCanvas.G_TL);
		
		if(Configs.sound)
			g.drawLine(Configs.x + 90, Configs.y + 72, Configs.x + 100, Configs.y + 72);
		else
			g.drawLine(Configs.x + 110, Configs.y + 72, Configs.x + 122, Configs.y + 72);
		
		if(Configs.deco)
			g.drawLine(Configs.x + 100, Configs.y + 92, Configs.x + 110, Configs.y + 92);
		else
			g.drawLine(Configs.x + 120, Configs.y + 92, Configs.x + 132, Configs.y + 92);
	}

	public void Key()
	{
		switch(mc.nKey)
		{
		case KEY_LEFT:
		case KEY_NUM4:
			if(cursor == 0)
				Configs.sound = true;
			else
				Configs.deco = true;
			break;
		case KEY_RIGHT:
		case KEY_NUM6:
			if(cursor == 0)
				Configs.sound = false;
			else
				Configs.deco = false;
			break;
		case KEY_UP:
		case KEY_NUM2:
		case KEY_DOWN:
		case KEY_NUM8:
			if(cursor == 0)
				cursor = 1;
			else
				cursor = 0;
			break;
		case KEY_CLR:
			play.gomode = false;
			
			FileOutputStream os;
			DataOutputStream dos;
			
			try
			{			
				os = new FileOutputStream("option.dat");
				dos = new DataOutputStream(os);
				
				dos.writeBoolean(Configs.sound);
				dos.writeBoolean(Configs.deco);
				
				dos.close();
			}
			catch(Exception ex)
			{
				
			}
			finally
			{
				dos = null;
				os = null;
				
				System.gc();	
			}
			break;
		}
	}
}