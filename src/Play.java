import javax.microedition.lcdui.*;
import com.xce.lcdui.XDisplay;
import java.io.DataInputStream;
import com.xce.io.FileInputStream;

//
// 본 게임 클래스
//
public class Play extends Define
{
	MainCanvas mc;
	Hero hero;
	Monster[] monster;
	Iface ifc;
	Map map;
	Gameover go;
	Item[] item;
	Objects[] obj;
	Gmenu gm;
	Teleport tp;
	Event event;
	Npc npc;
	Boss boss;
	Effect eff;
	Deco[] deco;
	
	public Image msgBack = null;
	public String msgName = "";
	public String msgContent1 = "";
	public String msgContent2 = "";
	
	boolean cantMove = false;
	
	public boolean gmmode = false;
	public boolean txmode = false;
	public boolean gimode = false;
	public boolean gdmode = false;
	public boolean gomode = false;
	
	boolean skenable;
	short skcount;
	
	short count;
	
//	====================================================================================	 
	private int nState;
	
	public Play(MainCanvas mc, int menu)
	{
		this.mc = mc;
		
		Configs.pages = new boolean[10];

		ChangeStage(0);
		
		if(menu == 1)
		{
			try
			{
				int[] tp = new int[3];
				
				FileInputStream is = new FileInputStream("save.dat");
				DataInputStream dis = new DataInputStream(is);
				
				tp[0] = dis.readInt();
				tp[1] = dis.readInt();
				tp[2] = dis.readInt();
				
				for(int i = 0; i < 10; i++)
				{
					Configs.pages[i] = dis.readBoolean();
				}
				
				dis.close();
				
				dis = null;
				is = null;
				
				ChangeStage(tp[2]);
				
				hero.hp = (byte) tp[0];
				hero.sp = (byte) tp[1];
				
				tp = null;
				System.gc();
				
				skenable = false;
				skcount = 1;
			}
			catch(Exception e)
			{
			}
		}
		else
			ChangeStage(-1);
		
		eff = new Effect();
	}

	public void ChangeStage(int stagenum)
	{
		switch(stagenum)
		{
		case -1:
			map = new Map(mc, -1);
			hero = new Hero(mc, map, 1, 3);
			item = new Item[0];
			monster = new Monster[0];
			obj = new Objects[0];
			deco = new Deco[0];
			break;
		case 0:
			map = new Map(mc, 0);
			hero = new Hero(mc, map, 1, 3);
			item = new Item[3];
			item[0] = new Item(mc, hero, map, 2, 0, 3, 3);
			item[1] = new Item(mc, hero, map, 2, 6, 13, 3);
			item[2] = new Item(mc, hero, map, 0, 1, 5, 1);
			monster = new Monster[0];
			obj = new Objects[1];
			obj[0] = new Objects(mc, 3, hero, map, monster, this, 14, 3, 1, false);
			deco = new Deco[3];
			deco[0] = new Deco(mc, map, 0, 2, 3);
			deco[1] = new Deco(mc, map, 0, 7, 3);
			deco[2] = new Deco(mc, map, 0, 12, 3);
			break;
		case 1:
			map = new Map(mc, 1);
			hero.map = map;
			hero.x = 1;
			hero.y = 3;
			monster = new Monster[1];
			monster[0] = new Monster(mc, 18, 3, map, hero);
			item = new Item[4];
			item[0] = new Item(mc, hero, map, 1, 0, 2, 3);
			item[1] = new Item(mc, hero, map, 2, 1, 5, 1);
			item[2] = new Item(mc, hero, map, 0, 2, 4, 1);
			item[3] = new Item(mc, hero, map, 2, 4, 14, 3);
			obj = new Objects[3];
			obj[0] = new Objects(mc, 1, hero, map, monster, this, 7, 1, 0, false);
			obj[1] = new Objects(mc, 3, hero, map, monster, this, 23, 3, 2, false);
			obj[2] = new Objects(mc, 0, hero, map, monster, this, 6, 1, 0, false);
			deco = new Deco[3];
			deco[0] = new Deco(mc, map, 0, 2, 3);
			deco[1] = new Deco(mc, map, 1, 8, 1);
			deco[2] = new Deco(mc, map, 0, 18, 3);
			break;
		case 2:
			map = new Map(mc, 2);
			hero.map = map;
			hero.x = 1;
			hero.y = 3;
			item = new Item[3];
			item[0] = new Item(mc, hero, map, 1, 0, 4, 3);
			item[1] = new Item(mc, hero, map, 0, 0, 7, 1);
			item[2] = new Item(mc, hero, map, 2, 5, 20, 3);
			monster = new Monster[2];
			monster[0] = new Monster(mc, 18, 3, map, hero);
			monster[1] = new Monster(mc, 11, 1, map, hero);
			obj = new Objects[2];
			obj[0] = new Objects(mc, 3, hero, map, monster, this, 23, 3, 3, false);
			obj[1] = new Objects(mc, 4, hero, map, monster, this, 21, 3, 0, false);
			deco = new Deco[3];
			deco[0] = new Deco(mc, map, 0, 2, 3);
			deco[1] = new Deco(mc, map, 1, 13, 1);
			deco[2] = new Deco(mc, map, 0, 18, 3);
			break;
		case 3:
			map = new Map(mc, 3);
			hero.map = map;
			hero.x = 1;
			hero.y = 2;
			item = new Item[3];
			item[0] = new Item(mc, hero, map, 1, 0, 4, 2);
			item[1] = new Item(mc, hero, map, 2, 3, 5, 2);
			item[2] = new Item(mc, hero, map, 0, 3, 10, 2);
			monster = new Monster[0];
			obj = new Objects[2];
			obj[0] = new Objects(mc, 4, hero, map, monster, this, 18, 2, 0, false);
			obj[1] = new Objects(mc, 3, hero, map, monster, this, 23, 3, 4, false);
			deco = new Deco[3];
			deco[0] = new Deco(mc, map, 2, 4, 2);
			deco[1] = new Deco(mc, map, 0, 2, 1);
			deco[2] = new Deco(mc, map, 0, 18, 3);
			break;
		case 4:
			map = new Map(mc, 4);
			hero.map = map;
			hero.x = 1;
			hero.y = 3;
			item = new Item[2];
			item[0] = new Item(mc, hero, map, 1, 0, 3, 3);
			item[1] = new Item(mc, hero, map, 0, 5, 10, 1);
			monster = new Monster[0];
			obj = new Objects[4];
			obj[0] = new Objects(mc, 0, hero, map, monster, this, 5, 1, 0, false);
			obj[1] = new Objects(mc, 1, hero, map, monster, this, 3, 1, 1, false);
			obj[2] = new Objects(mc, 3, hero, map, monster, this, 22, 3, 5, true);
			obj[3] = new Objects(mc, 5, hero, map, monster, this, 15, 1, 0, false);
			deco = new Deco[0];
			break;
		case 5:
			map = new Map(mc, 5);
			hero.map = map;
			hero.x = 2;
			hero.y = 1;
			item = new Item[2];
			item[0] = new Item(mc, hero, map, 1, 0, 9, 1);
			item[1] = new Item(mc, hero, map, 0, 4, 15, 2);
			monster = new Monster[0];
			obj = new Objects[4];
			obj[0] = new Objects(mc, 3, hero, map, monster, this, 24, 3, 6, true);
			obj[1] = new Objects(mc, 0, hero, map, monster, this, 5, 3, 0, false);
			obj[2] = new Objects(mc, 1, hero, map, monster, this, 7, 1, 1, false);
			obj[3] = new Objects(mc, 5, hero, map, monster, this, 20, 3, 0, false);
			deco = new Deco[0];
			break;
		case 6:
			map = new Map(mc, 6);
			hero.map = map;
			hero.x = 1;
			hero.y = 3;
			item = new Item[2];
			item[0] = new Item(mc, hero, map, 1, 0, 7, 1);
			item[1] = new Item(mc, hero, map, 0, 6, 9, 1);
			monster = new Monster[0];
			obj = new Objects[7];
			obj[0] = new Objects(mc, 3, hero, map, monster, this, 24, 3, 7, true);
			obj[1] = new Objects(mc, 5, hero, map, monster, this, 13, 3, 0, false);
			obj[2] = new Objects(mc, 2, hero, map, monster, this, 6, 3, 0, false);
			obj[3] = new Objects(mc, 2, hero, map, monster, this, 10, 3, 0, false);
			obj[4] = new Objects(mc, 2, hero, map, monster, this, 20, 3, 0, false);
			obj[5] = new Objects(mc, 4, hero, map, monster, this, 13, 1, 0, false);
			obj[6] = new Objects(mc, 4, hero, map, monster, this, 14, 1, 0, false);
			deco = new Deco[0];
			break;
		case 7:
			map = new Map(mc, 7);
			hero.map = map;
			hero.x = 1;
			hero.y = 3;
			item = new Item[3];
			item[0] = new Item(mc, hero, map, 1, 0, 3, 2);
			item[1] = new Item(mc, hero, map, 0, 7, 7, 1);
			item[2] = new Item(mc, hero, map, 2, 2, 3, 0);
			monster = new Monster[1];
			monster[0] = new Monster(mc, 3, 0, map, hero);
			obj = new Objects[4];
			obj[0] = new Objects(mc, 3, hero, map, monster, this, 24, 3, 8, true);
			obj[1] = new Objects(mc, 5, hero, map, monster, this, 0, 0, 0, false);
			obj[2] = new Objects(mc, 2, hero, map, monster, this, 10, 3, 0, false);
			obj[3] = new Objects(mc, 2, hero, map, monster, this, 0, 0, 0, false);
			deco = new Deco[0];
			break;
		case 8:
			map = new Map(mc, 8);
			hero.map = map;
			hero.x = 1;
			hero.y = 0;
			item = new Item[2];
			item[0] = new Item(mc, hero, map, 1, 0, 4, 1);
			item[1] = new Item(mc, hero, map, 0, 8, 19, 3);
			monster = new Monster[3];
			monster[0] = new Monster(mc, 6, 1, map, hero);
			monster[1] = new Monster(mc, 10, 1, map, hero);
			monster[2] = new Monster(mc, 24, 3, map, hero);
			obj = new Objects[4];
			obj[0] = new Objects(mc, 3, hero, map, monster, this, 20, 1, 9, false);
			obj[1] = new Objects(mc, 4, hero, map, monster, this, 22, 1, 0, false);
			obj[2] = new Objects(mc, 4, hero, map, monster, this, 20, 1, 0, false);
			obj[3] = new Objects(mc, 2, hero, map, monster, this, 21, 3, 0, false);
			deco = new Deco[0];
			break;
		case 9:
			map = new Map(mc, 9);
			hero.map = map;
			hero.x = 0;
			hero.y = 2;
			item = new Item[2];
			item[0] = new Item(mc, hero, map, 1, 0, 3, 2);
			item[1] = new Item(mc, hero, map, 0, 9, 19, 2);
			monster = new Monster[0];
			obj = new Objects[11];
			obj[0] = new Objects(mc, 3, hero, map, monster, this, 22, 2, 10, false);
			obj[1] = new Objects(mc, 4, hero, map, monster, this, 5, 2, 0, false);
			obj[2] = new Objects(mc, 4, hero, map, monster, this, 6, 2, 0, false);
			obj[3] = new Objects(mc, 4, hero, map, monster, this, 8, 2, 0, false);
			obj[4] = new Objects(mc, 4, hero, map, monster, this, 10, 2, 0, false);
			obj[5] = new Objects(mc, 4, hero, map, monster, this, 11, 2, 0, false);
			obj[6] = new Objects(mc, 4, hero, map, monster, this, 13, 2, 0, false);
			obj[7] = new Objects(mc, 4, hero, map, monster, this, 14, 2, 0, false);
			obj[8] = new Objects(mc, 4, hero, map, monster, this, 15, 2, 0, false);
			obj[9] = new Objects(mc, 4, hero, map, monster, this, 17, 2, 0, false);
			obj[10] = new Objects(mc, 4, hero, map, monster, this, 19, 2, 0, false);
			deco = new Deco[0];
			break;
		case 10:
			map = new Map(mc, 10);
			hero.map = map;
			hero.x = 1;
			hero.y = 3;
			item = new Item[1];
			item[0] = new Item(mc, hero, map, 1, 0, 4, 3);
			monster = new Monster[0];
			obj = new Objects[6];
			obj[0] = new Objects(mc, 3, hero, map, monster, this, 24, 3, 11, false);
			obj[1] = new Objects(mc, 5, hero, map, monster, this, 1, 1, 0, false);
			obj[2] = new Objects(mc, 4, hero, map, monster, this, 8, 3, 0, false);
			obj[3] = new Objects(mc, 4, hero, map, monster, this, 10, 3, 0, false);
			obj[4] = new Objects(mc, 4, hero, map, monster, this, 14, 3, 0, false);
			obj[5] = new Objects(mc, 4, hero, map, monster, this, 20, 3, 0, false);
			deco = new Deco[0];
			break;
		case 11:
			map = new Map(mc, 11);
			hero.map = map;
			hero.x = 0;
			hero.y = 3;
			item = new Item[1];
			item[0] = new Item(mc, hero, map, 1, 0, 3, 3);
			monster = new Monster[1];
			monster[0] = new Monster(mc, 21, 3, map, hero);
			obj = new Objects[9];
			obj[0] = new Objects(mc, 3, hero, map, monster, this, 24, 3, 12, false);
			obj[1] = new Objects(mc, 2, hero, map, monster, this, 18, 3, 0, false);
			obj[2] = new Objects(mc, 4, hero, map, monster, this, 17, 3, 0, false);
			obj[3] = new Objects(mc, 4, hero, map, monster, this, 5, 2, 0, false);
			obj[4] = new Objects(mc, 0, hero, map, monster, this, 8, 3, 0, false);
			obj[5] = new Objects(mc, 1, hero, map, monster, this, 9, 3, 0, false);
			obj[6] = new Objects(mc, 2, hero, map, monster, this, 10, 1, 0, false);
			obj[7] = new Objects(mc, 1, hero, map, monster, this, 11, 1, 0, false);
			obj[8] = new Objects(mc, 2, hero, map, monster, this, 13, 0, 0, false);
			deco = new Deco[0];
			break;
		case 12:
			map = new Map(mc, 12);
			hero.map = map;
			hero.x = 1;
			hero.y = 3;
			item = new Item[0];
			monster = new Monster[0];
			obj = new Objects[0];
			deco = new Deco[0];
			break;
		}
		ifc = new Iface(hero);
		go = new Gameover(mc, hero);
		gm = new Gmenu(mc, this);
		tp = new Teleport(mc, hero, map);
		
		npc = new Npc(mc, 0, 0, false);
		boss = new Boss(mc, 0, 0, false);
		
		hero.sk = 1;
		hero.skenable = false;
		hero.direction = false;
		
		event = new Event(mc, this, hero, npc, boss, map);
		
		Configs.sensor = false;
		Configs.getkey = false;
		
		System.gc();
	}

	public void Start(Graphics g)
	{
		mc.InnerState(IN_LOOP);
	}

	public void Draw(Graphics g)
	{
		if(!gmmode)
		{
			cantMove = Lib.Message(g, msgBack, msgName, msgContent1, msgContent2);
			if(cantMove) return;
			
			g.fillRect(0, 0, XDisplay.width, XDisplay.height2);

			event.Crash(g);
			
			map.Draw(g);

			for(int i=0;i<deco.length;i++)
			{
				deco[i].Draw(g);				
			}
			
			for(int i=0;i<obj.length;i++)
			{
				obj[i].Draw(g);
			}
			
			hero.Draw(g);

			if(hero.hp > 0)
			{
				if(count >=30)
				{
					if(hero.hp < 10)
						hero.hp++;
					
					if(hero.sp < 50)
						hero.sp ++;
					
					count = 0;
				}
				else
					count ++;
			}

			if(skenable)
			{
				eff.hero = hero;
				eff.map = map;
				eff.g = g;
				eff.Draw(skcount);
				skcount++;
				if(skcount>=4)
				{
					skcount = 0;
					skenable = false;
				}
			}
			
			for(int i = 0 ; i < monster.length ; i++)
			{
				monster[i].move();
				
				monster[i].Draw(g);
			}
			
			for(int i = 0 ; i < item.length ; i++)
			{
				if(item[i].ilive)
				{
					item[i].Draw(g);
				}
			}
			
			tp.Draw(g);
			
			go.Draw(g);
			
			if(event.eventline[event.eventline.length - 1])
				ifc.Draw(g);
			
			npc.Draw(g);
			boss.Draw(g);
			
			count++;
		}
		else
		{
			gm.Draw(g);
		}
	}

	public void Key()
	{
		if(mc.KeyPress != 0)
		{
			if(!gmmode && hero .hp > 0)
			{
				if(!cantMove)
				{
					hero.Key();
					
					for(int i = 0; i < monster.length; i++)
					{
						monster[i].Key();
					}
					
					tp.skill();
					
					switch(mc.nKey)
					{
					case KEY_CLR:
						gmmode = true;
						break;
					case KEY_FIRE:
					case KEY_NUM5:
						if(count >= 10)
						{
							skenable = true;
							count = 0;
						}
						break;
					case KEY_VOL_UP:
						hero.sp = 50;
						mc.nKey = 0;
						break;
					case KEY_VOL_DOWN:
						ChangeStage(map.stage + 1);
						mc.nKey = 0;
						break;
					case Define.KEY_CALL:
						Configs.sensor = false;
						mc.nKey = 0;
						break;
					}
				}
				else
				{
					if(mc.KeyPress == 1)
					{
						switch(mc.nKey)
						{
						case KEY_CLR:
						case KEY_FIRE:
							msgBack = null;
							msgName = "";
							msgContent1 = "";
							msgContent2 = "";
							break;
						case KEY_POUND:
							msgBack = null;
							msgName = "";
							msgContent1 = "";
							msgContent2 = "";
							for(int i=0;i<event.eventline.length - 1;i++)
							{
								event.eventline[i] = true;
							}
							
							boss.live = false;
							npc.live = false;
							break;
						}
					}
				}
			}
			else
			{
				gm.Key();
			}
		}
	}

	public void End(Graphics g)
	{
		switch(nState)
		{
		case PREV:
			mc.GameState(MENU);
			break;
		}
		mc.InnerState(IN_START);
	}
}
