import javax.microedition.lcdui.*;
import com.xce.io.*;

//
// 게임 시작 클래스 - Menu에서 사용
//
public class Start extends Define 
{
	MainCanvas mc;
	Image[] img;
	int cur;
	
	public Start(MainCanvas mc)
	{
		this.mc = mc;
		img = new Image[3];
		
		try
		{
			img[0] = Image.createImage("menu/newgame.png");
			img[1] = Image.createImage("menu/gameload.png");
			img[2] = Image.createImage("menu/cursor.png");
		}
		catch(Exception ex) {}
	}
	
	// 그림 그리는 메서드
	public void Draw(Graphics g)
	{
		g.setColor(0x000000);
		g.fillRect(Configs.x + 60, Configs.y + 50, 116, 92);
		g.setColor(240,240,240);

		g.drawImage(img[0], Configs.x + 62, Configs.y + 60, MainCanvas.G_TL);
		g.drawImage(img[1], Configs.x + 62, Configs.y + 90, MainCanvas.G_TL);
	
		g.drawImage(img[2], Configs.x + 62, Configs.y + 58 + (cur * 30), MainCanvas.G_TL);
	}
	public void Key()
	{
		if(mc.KeyPress == 1)
		{
			switch(mc.nKey)
			{
			case KEY_NUM2:
			case KEY_UP:
				cur = 0;
				break;
			case KEY_NUM8:
			case KEY_DOWN:
				cur = 1;
				break;
			case KEY_NUM5:
			case KEY_FIRE:
				switch(cur)
				{
				case 0:
					Configs.pages = new boolean[10];
					mc.play = new Play(mc, 0);
					mc.GameState(PLAY);
					mc.InnerState(IN_START);
					break;
				case 1:
					try
					{
						if(!XFile.exists("save.dat"))
							return;
					}
					catch(Exception e) { System.out.println("파일 검사 오류 : " + e); }
					Configs.pages = new boolean[10];
					mc.play = new Play(mc, 1);
					mc.GameState(PLAY);
					mc.InnerState(IN_START);
					break;
				}
				break;
			}
		}
	}
}	

