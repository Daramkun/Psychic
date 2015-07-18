import javax.microedition.lcdui.*;

//
// 게임 메뉴 클래스 - Play에서 사용
//
public class Gmenu extends Define
{
	MainCanvas mc;
	
	Play play;

	Ginformation gi;
	Document dc;
	Goption go;
	
	Image[] gmenu;
	
	short cur = 41;  //커서 위치
	byte page;
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	public Gmenu(MainCanvas mc, Play play)
	{
		this.mc = mc;
		this.play = play;
		gi = new Ginformation(mc, play, this);
		dc = new Document(mc, play, this);
		go = new Goption(mc, play, this);
		
		try
		{
			gmenu = new Image[3];
			gmenu[0] = Image.createImage("menu/gmenu.png");
			gmenu[1] = Image.createImage("menu/menu1.png");
			gmenu[2] = Image.createImage("menu/select.png");
		}
		catch(Exception ex) {}
	}
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	public void Draw(Graphics g)
	{
		g.setColor(0x000000);
		g.fillRect(Configs.x, Configs.y, 176, 178);
		try
		{
			g.drawImage(gmenu[0], Configs.x + 70, Configs.y, MainCanvas.G_TL);
			g.drawImage(gmenu[1], Configs.x, Configs.y, MainCanvas.G_TL);
			g.drawImage(gmenu[2], Configs.x + 71, Configs.y + cur, MainCanvas.G_TL);
		}
		catch(Exception ex){}
		
		if(play.gimode)
			gi.draw(g);
		if(play.gdmode)
			dc.Draw(g);
		if(play.gomode)
			go.Draw(g);
	}

	public void Key()
	{
		if(mc.KeyPress == 1)
		{
			if(!play.gimode && !play.gdmode && !play.gomode)
			{
				switch(mc.nKey)
				{     
					case KEY_UP:
					case KEY_NUM2:
						if(cur > 41)
							cur -= 27;
						else
							cur = (short) 149;
						break;
					case KEY_DOWN:
					case KEY_NUM8:
						if(cur < 135)
							cur += 27;
						else
							cur = 41;
						break;
					case KEY_FIRE:
					case KEY_NUM5:
						if(cur == 41)
							play.gmmode = false;
						
						if(cur == 68)
							play.gdmode = true;
						
						if(cur == 95)
							play.gimode = true;
						
						if(cur == 122)
							play.gomode = true;
						
						if(cur == 149)
						{
							mc.GameState = MENU;
							mc.play = null;
							System.gc();
						}
						break;
					case KEY_CLR:
						play.gmmode = false;
						mc.nKey = 0;
						break;
				}
			}
	
			if(play.gimode)
				gi.Key();
			
			if(play.gdmode)
				dc.Key();
			
			if(play.gomode)
				go.Key();
		}
	}
}