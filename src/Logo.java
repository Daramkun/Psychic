import javax.microedition.lcdui.*;

//
// 로고 클래스
//
public class Logo extends Define
{
	MainCanvas mc;
	
//	====================================================================================	 
	private byte nState;
	Image logo;
	String loaded;
	
	byte load;
	
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// 생성자 
	public Logo(MainCanvas mc)
	{
		try
		{
			logo = Image.createImage("etc/logo.png");
		}
		catch(Exception ex)
		{}
		
		Common.monl = new Image[4];
		Common.monr = new Image[4];
		
		Common.mg = new Image[2];
		Common.press = new Image[5];
		Common.sensor = new Image[2];
		Common.trap = new Image[2];
		
		Common.doc = new Image[5];
		
		this.mc = mc;
	}
	
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	public void Start(Graphics g)
	{
		g.setColor(0xffffff);
		g.fillRect(0, 0, 176, 178);
		mc.InnerState(IN_LOOP);
		
		Draw(g);
	}
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	public void Key()
	{
		
	}
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	public void Draw(Graphics g)
	{
		g.setColor(0x000000);
		g.fillRect(Configs.x, Configs.y, 176, 178);
		
		g.drawImage(logo, Configs.x + 40, Configs.y + 70, MainCanvas.G_TL);
		
		try
		{
			switch(load)
			{
			case 0:
				Common.monr[0] = Image.createImage("monster/mon0.png");
				loaded = "mon0.png";
				break;
			case 1:
				Common.monr[1] = Image.createImage("monster/mon1.png");
				loaded = "mon1.png";
				break;
			case 2:
				Common.monr[2] = Image.createImage("monster/mon2.png");
				loaded = "mon2.png";
				break;
			case 3:
				Common.monr[3] = Image.createImage("monster/mon3.png");
				loaded = "mon3.png";
				break;
			case 4:
				Common.monl[0] = Image.createImage("monster/mon0a.png");
				loaded = "mon0a.png";
				break;
			case 5:
				Common.monl[1] = Image.createImage("monster/mon1a.png");
				loaded = "mon1a.png";
				break;
			case 6:
				Common.monl[2] = Image.createImage("monster/mon2a.png");
				loaded = "mon2a.png";
				break;
			case 7:
				Common.monl[3] = Image.createImage("monster/mon3a.png");
				loaded = "mon3a.png";
				break;
			case 8:
				Common.mondead = Image.createImage("monster/mond.png");
				loaded = "mond.png";
				break;
			case 9:
				Common.monctrl = Image.createImage("etc/control.png");
				loaded = "control.png";
				break;
			case 10:
				Common.door = Image.createImage("object/door.png");
				loaded = "door.png";
				break;
			case 11:
				Common.sensor[0] = Image.createImage("trap/sensor0.png");
				loaded = "sensor0.png";
				break;
			case 12:
				Common.sensor[1] = Image.createImage("trap/sensor1.png");
				loaded = "sensor1.png";
				break;
			case 13:
				Common.key = Image.createImage("object/key.png");
				loaded = "key.png";
				break;
			case 14:
				Common.mg[0] = Image.createImage("trap/mg.png");
				loaded = "mg.png";
				break;
			case 15:
				Common.mg[1] = Image.createImage("trap/mga.png");
				loaded = "mga.png";
				break;
			case 16:
				Common.trap[0] = Image.createImage("trap/trap0.png");
				loaded = "trap0.png";
				break;
			case 17:
				Common.trap[1] = Image.createImage("trap/trap1.png");
				loaded = "trap1.png";
				break;
			case 18:
				Common.press[0] = Image.createImage("trap/BB1.png");
				loaded = "BB1.png";
				break;
			case 19:
				Common.press[1] = Image.createImage("trap/BB2.png");
				loaded = "BB2.png";
				break;
			case 20:
				Common.press[2] = Image.createImage("trap/BB3.png");
				loaded = "BB3.png";
				break;
			case 21:
				Common.press[3] = Image.createImage("trap/BB4.png");
				loaded = "BB4.png";
				break;
			case 22:
				Common.press[4] = Image.createImage("trap/BB5.png");
				loaded = "BB5.png";
				break;
			case 23:
				Common.ocur = Image.createImage("etc/ocur.png");
				loaded = "ocur.png";
				break;
			case 24:
				Common.itext = Image.createImage("item/text.png");
				loaded = "text.png";
				break;
			case 25:
				Common.isave = Image.createImage("item/save.png");
				loaded = "save.png";
				break;
			case 26:
				Common.ihelp = Image.createImage("item/help.png");
				loaded = "help.png";
				break;
			case 27:
				Common.doc[0] = Image.createImage("info/1.png");
				loaded = "1.png";
				break;
			case 28:
				Common.doc[1] = Image.createImage("info/2.png");
				loaded = "2.png";
				break;
			case 29:
				Common.doc[2] = Image.createImage("info/3.png");
				loaded = "3.png";
				break;
			case 30:
				Common.doc[3] = Image.createImage("info/4.png");
				loaded = "4.png";
				break;
			case 31:
				Common.doc[4] = Image.createImage("info/5.png");
				loaded = "5.png";
				break;
			case 32:
				Common.pipe = Image.createImage("etc/pipe.png");
				loaded = "pipe.png";
				break;
			case 33:
				Common.com = Image.createImage("etc/com.png");
				loaded = "com.png";
				break;
			case 34:
				Common.dead = Image.createImage("etc/dead.png");
				loaded = "dead.png";
				break;
			case 35:
				Common.light = Image.createImage("etc/light.png");
				loaded = "light.png";
				break;
			}
		}
		catch(Exception ex) {}
		
		load++;
		
		g.setColor(0xffff00);
		g.fillRect(Configs.x + (176 / 2 - (36 * 3) / 2), Configs.y + 140, (load * 3), 10);
		
		g.setColor(0xffffff);
		g.drawRect(Configs.x + (176 / 2 - (36 * 3) / 2), Configs.y + 140, (36 * 3), 10);
		
		g.drawString(loaded + "파일 로드", Configs.x + 18, Configs.y + 152, MainCanvas.G_TL);
		
		if(load >= 36)
		{
			mc.GameState(MENU);
			mc.InnerState(IN_START);
			logo = null;
			System.gc();
		}
	}
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	public void End(Graphics g)
	{
		switch(nState)
		{
		case NEXT:
			mc.GameState(MENU);
			break;
		case PREV:
			mc.GameState(INTRO);
			break;
		}
		mc.InnerState(IN_START);
	}
//	====================================================================================
}