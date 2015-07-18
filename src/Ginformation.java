import javax.microedition.lcdui.*;

//
// 게임 정보 클래스 - Gmenu에서 사용
//
public class Ginformation extends Define {
	
	MainCanvas mc;
	Play play;
	Gmenu gm;
	Image menu;
	
	byte page=0;
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	public Ginformation(MainCanvas mc, Play play, Gmenu gm)
	{
		try
		{
			menu = Image.createImage("menu/menu3.png");
		}
		catch(Exception ex)
		{
			
		}
		
		this.mc = mc;
		this.play = play;
		this.gm = gm;
	}
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// 그림 그리는 메서드
	public void draw(Graphics g)
	{
		g.drawImage(menu,Configs.x,Configs.y,MainCanvas.G_TL);
			
		g.setColor(0x000000);
		g.fillRect(Configs.x + 35,Configs.y + 0,150,180);
		g.setColor(240,240,240);

		g.drawImage(Common.doc[page], Configs.x + 54, Configs.y + 30, MainCanvas.G_TL);
	}
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
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
			case KEY_CLR:
				play.gimode = false;
				break;
			}
		}
	}
}
