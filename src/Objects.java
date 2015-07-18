import javax.microedition.lcdui.*;

//
// 개체 클래스 - Play에서 사용
//
public class Objects extends Define 
{
	MainCanvas mc;
	
	int type=4;
	int frame = 0; //압축기 프레임
	int count = 0;//압축기 카운트
	
	public byte x = 3;
	public byte y = 3; //함정 좌표
	
	boolean backframe = false;
	
	Hero hero;
	Map map;
	Monster[] mon;
	Play play;
	Bullet bullet;
	
	boolean blive;
	boolean direction = false;
	boolean keyenable = false;
	
	int bbc;
	
	int gotos = 0;
	
	PlaySound ps;
	
	boolean enable;
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	public Objects(MainCanvas mc, int type, Hero hero, Map map, Monster[] mon, Play play, int x, int y, int gotos, boolean keyenable)
	{
		frame = 0;
		
		this.x = (byte)x;
		this.y = (byte)y;
		this.gotos = gotos;
		this.play = play;
		
		try{
			switch(type)
			{
			case 1:
				if(gotos == 0)
				{
					frame = 0;
					direction = true;
				}
				else
				{
					frame = 1;
				}
				break;
			case 2:
				enable = true;
				break;
			case 3:
				this.keyenable = keyenable;
				break;
			case 5:
				enable = true;
				this.keyenable = keyenable;
				break;
			}
			this.type = type;
		}
		catch(Exception ex)
		{

		}
		
		this.map = map;
		this.hero = hero;
		this.mon = mon;
		
		this.mc = mc;
		
		ps = new PlaySound(0);
		ps.start();
	}
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	public void Draw(Graphics g)
	{
		
		switch(type)
		{
		case 0:	// 센서
			g.drawImage(Common.sensor[frame], Configs.x + (x * 25) - (map.x * 25) + 10, 13 + Configs.y + (y * 25), MainCanvas.G_TL);
			break;
		case 1:	// 총
			g.drawImage(Common.mg[frame], Configs.x + (x * 25) - (map.x * 25), 13 + Configs.y + (y * 25), MainCanvas.G_TL);
			break;
		case 2:	// 트랩
			if(enable)
				g.drawImage(Common.trap[0], Configs.x + (x * 25) - (map.x * 25), 20 + Configs.y + (y * 25), MainCanvas.G_TL);
			else
				g.drawImage(Common.trap[1], (x * 25) - (map.x * 25), 20 + (y * 25), MainCanvas.G_TL);
			break;
		case 3:	// 문
			g.drawImage(Common.door, Configs.x + (x * 25) - (map.x * 25) + 5, 3 + Configs.y + (y * 25), MainCanvas.G_TL);
			break;
		case 4:	// 압축기
			g.drawImage(Common.press[frame], Configs.x + (x * 25) - (map.x * 25), 3 + Configs.y + (y * 25) - 25, MainCanvas.G_TL);
			break;
		case 5:
			if(enable)
				g.drawImage(Common.key, Configs.x + (x * 25) - (map.x * 25),  3 + Configs.y + (y * 25), MainCanvas.G_TL);
			break;
		}
		
		if(type == 1)
		{
			if(Configs.sensor)
			{
					if(!blive)
					{
						if(bbc>=15)
						{
							bullet = new Bullet(mc, direction, map);
							blive = true;
							bullet.x = (short)(this.x * 25);
							bullet.y = (short)this.y;
							bbc=0;
							count = 0;
						}
					}
					else
					{
						if(count >= 14)
						{
							blive = false;
							count = 0;
						}
						else
						{
							bullet.shotting();
							bullet.draw(g);
							if(!Lib.hbCrash(hero, bullet, map))
							{
								hero.hp -= 3;
								blive = false;
							}
							count++;
						}
				}
			}
		}
		
		if(type == 0)
		{
			if(count>=2)
			{
				if(frame==1)
					frame = 0;
				else
					frame = 1;
				count = 0;
			}
			else
			{
				count ++;
			}
		}
		
		// 압축기일 경우 프레임 변경
		if(type == 4)
		{
			if(count>=2)
			{
				if(!backframe)
				{
					if(frame<4)
						frame ++;
					else
						backframe = true;
				}
				else
				{
					if(frame>0)
						frame --;
					else
						backframe = false;
				}
				count = 0;
			}
			else
			{
				count ++;
			}
		}
		
		// 주인공과 개체의 충돌시
		if(!Lib.hoCrash(hero, this, map))
		{
			if(frame == 4 && type == 4)
				hero.hp = 0;
			else if(type == 2 && enable == true)
			{
				hero.hp = 0;
				enable = false;
			}
			else if(type == 3)
			{
				if(mc.nKey == KEY_UP || mc.nKey == KEY_NUM2)
				{
					if(keyenable)
					{
						if(Configs.getkey)
						{
							play.ChangeStage(gotos);
						}
						else
						{
							play.msgName = "리사";
							play.msgContent1 = "문이 잠겨있네.";
						}
					}
					else
					{
						play.ChangeStage(gotos);
					}
					ps.play("sound/door.mmf", false);
				}
			}
			else if(type == 0)
			{
				if(!(hero.sk == 2 && hero.skenable))
				{
					Configs.sensor = true;
				}
			}
			else if(type == 5)
			{
				Configs.getkey = true;
				enable = false;
			}
		}
		
		// 몬스터와 개체의 충돌시
		for(int i=0;i<mon.length;i++)
		{
			if(!Lib.moCrash(mon[i], this))
			{
				if(mon[i].live)
				{
					if(frame == 4 && type == 4)
					{
						mon[i].live = false;
						ps.play("sound/die.mmf", false);
					}
					else if(type == 2 && enable == true)
					{
						mon[i].live = false;
						enable = false;
						ps.play("sound/die.mmf", false);
					}
				}
			}
		}
		
		bbc++;
	}
}