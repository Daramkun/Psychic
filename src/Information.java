import javax.microedition.lcdui.*;

//
// 게임 정보 클래스 - Menu에서 사용
//
public class Information extends Define
{	
	MainCanvas mc;
	
	byte page=0;
	
	public Information(MainCanvas mc)
	{
		this.mc = mc;
	}
	
	// 그림 그리는 메서드
	public void draw(Graphics g)
	{
		g.setColor(0x000000);
		g.fillRect(Configs.x + 60, Configs.y + 50, 116, 92);
		g.setColor(240,240,240);
		
		try
		{
			g.drawImage(Common.doc[page], Configs.x + 70, Configs.y + 32, MainCanvas.G_TL);
		}
		catch(Exception ex) {  }
	}
	
	public void Key()
	{
		if(mc.KeyPress == 1)
		{
			switch(mc.nKey)
			{
			case KEY_RIGHT:
			case KEY_NUM6:
				if(page>=0 && page < 4)
					page ++;
				break;
			case KEY_LEFT:
			case KEY_NUM4:
				if(page<=4 && page>0)
					page --;
				break;
			}
		}
	}
}