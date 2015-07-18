import javax.microedition.lcdui.*;

//
// 메뉴 클래스
//
public class Menu extends Define
{	
	MainCanvas mc;
	Image[] menu;
	Image[] img;
	
	byte cursor = 0;  //커서 위치

	Start sta;
	Information inf;
	Option opn;
	Credit crt;

	boolean st;
	boolean in;
	boolean op;
	boolean cr;
	
	byte count = 0;
	
//	====================================================================================	 
	private byte nState;
	
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// 생성자 
	public Menu(MainCanvas mc)
	{
		this.mc = mc;
		inf = new Information(mc);
		crt = new Credit(mc);
		opn = new Option(mc);
		sta = new Start(mc);
		
		try
		{
			menu = new Image[8];
			menu[0] = Image.createImage("menu/psychic.png");
			menu[1] = Image.createImage("menu/copyright.png");
			menu[2] = Image.createImage("menu/start.png");
			menu[3] = Image.createImage("menu/info.png");
			menu[4] = Image.createImage("menu/option.png");
			menu[5] = Image.createImage("menu/credit.png");
			menu[6] = Image.createImage("menu/exit.png");
			menu[7] = Image.createImage("menu/cursor.png");
			
			img = new Image[5];
			img[0] = Image.createImage("menu/startside.png");
			img[1] = Image.createImage("menu/infoside.png");
			img[2] = Image.createImage("menu/optionside.png");
			img[3] = Image.createImage("menu/creditside.png");
			img[4] = Image.createImage("menu/exitside.png");
		}
		catch(Exception ex)
		{

		}
	}
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	public void Start(Graphics g)
	{
		mc.InnerState(IN_LOOP);
	}
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	public void Draw(Graphics g)
	{
		g.fillRect(Configs.x, Configs.y, 176, 178);
		// 제목
		g.drawImage(menu[0], Configs.x + 91, Configs.y + 5, MainCanvas.G_TL);
		// 카피라이트
		g.drawImage(menu[1], Configs.x + 103, Configs.y + 152, MainCanvas.G_TL);
		// 시작
		g.drawImage(menu[2], Configs.x + 62, Configs.y + 62, MainCanvas.G_TL);
		// 정보
		g.drawImage(menu[3], Configs.x + 62, Configs.y + 80, MainCanvas.G_TL);
		// 옵션
		g.drawImage(menu[4], Configs.x + 62, Configs.y + 98, MainCanvas.G_TL);
		// 크레딧
		g.drawImage(menu[5], Configs.x + 62, Configs.y + 116, MainCanvas.G_TL);
		// 종료
		g.drawImage(menu[6], Configs.x + 62, Configs.y + 134, MainCanvas.G_TL);
		// 커서
		g.drawImage(menu[7], Configs.x + 61, 60 + Configs.y + (cursor * 18), MainCanvas.G_TL);
			
		g.drawImage(img[cursor], Configs.x, Configs.y, MainCanvas.G_TL);
			
		if(st)
			sta.Draw(g);
			
		if(in)
			inf.draw(g);
			
		if(op)
			opn.Draw(g);
		
		if(cr)
			crt.Draw(g);
	}
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	public void Key()
	{
		mc.intro = null;
		mc.logo = null;
		
		if(mc.KeyPress == 1)
		{
			if(st == false && in == false && op == false && cr == false)
			{
				switch(mc.nKey)
				{
				case KEY_UP:
				case KEY_NUM2:
					if(cursor!=0)
						cursor--;
					else
						cursor = 4;
					break;
				case KEY_DOWN:
				case KEY_NUM8:
					if(cursor!=4)
						cursor++;
					else
						cursor = 0;
					break;
				case KEY_FIRE:
				case KEY_NUM5:
					switch(cursor)
					{
					case 0:
						st = true;
						break;
					case 1:
						in = true;
						break;
					case 2:
						op = true;
						break;
					case 3:
						cr = true;
						break;
					case 4:
						mc.avm.notifyDestroyed();
						break;
					}
					break;
				}
			}
			else
			{
				if(st)
					sta.Key();
				
				if(in)
					inf.Key();
				
				if(op)
					opn.Key();
				
				if(mc.nKey == KEY_CLR)
				{
					st = in = op = cr = false;
				}
			}
		}
		
	}
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	public void End(Graphics g)
	{
		switch(nState)
		{
		case NEXT:
			mc.GameState(PLAY);
			break;
		case PREV:
			mc.GameState(LOGO);
			break;
		}
		mc.InnerState(IN_START);
	}
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
//	====================================================================================
}