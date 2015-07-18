import javax.microedition.lcdui.*;
import java.io.DataOutputStream;
import com.xce.io.FileOutputStream;

//
// 옵션 클래스 - Menu에서 사용
//
public class Option extends Define 
{
	MainCanvas mc;
	int cursor;
	
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	public Option(MainCanvas mc)
	{
		this.mc = mc;
	}
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// 그림 그리는 메서드
	public void Draw(Graphics g)
	{
		g.setColor(0x000000);
		g.fillRect(Configs.x + 60, Configs.y + 50, 116, 92);
		g.setColor(240,240,240);
		g.drawString("<환경설정>", Configs.x + 90, Configs.y + 55, MainCanvas.G_TL);
		g.drawString("소리 : ON  OFF", Configs.x + 90, Configs.y + 75, MainCanvas.G_TL);
		g.drawString("장식물 : ON  OFF", Configs.x + 90, Configs.y + 95, MainCanvas.G_TL);
		g.setColor(0xff0000);
		
		if(cursor == 0)
			g.drawImage(Common.ocur, Configs.x + 80, Configs.y + 75, MainCanvas.G_TL);
		else
			g.drawImage(Common.ocur, Configs.x + 80, Configs.y + 95, MainCanvas.G_TL);
		
		if(Configs.sound)
			g.drawLine(Configs.x + 130, Configs.y + 88, Configs.x + 140, Configs.y + 88);
		else
			g.drawLine(Configs.x + 150, Configs.y + 88, Configs.x + 162, Configs.y + 88);
		
		if(Configs.deco)
			g.drawLine(Configs.x + 140, Configs.y + 108, Configs.x + 150, Configs.y + 108);
		else
			g.drawLine(Configs.x + 160, Configs.y + 108, Configs.x + 172, Configs.y + 108);
	}
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
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
		case KEY_FIRE:
			
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
			
			mc.GameState(MENU);
			break;
		}
	}
}

