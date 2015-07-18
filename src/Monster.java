import javax.microedition.lcdui.*;

//
// 몬스터 클래스 - Play에서 사용
//
public class Monster extends Define
{
	// 총알
	Bullet bullet;
	// 매인 캔버스
	MainCanvas mc;
	
	// 몬스터의 좌표(타일 기준)
	public byte x, y;
	// 몬스터가 바라보는 방향(false가 오른쪽, true가 왼쪽)
	public boolean direction;
	// 몬스터 원래 x
	int def;
	// 몬스터가 움직이는 프레임
	int frame;
	// 조종당하는 경우 true, 자신이 움직이는 경우 false
	public boolean control;
	// 이동 카운터
	int count = 0;
	// 총알 카운터
	int bcount = 0;
	// 주인공
	Hero hero;
	// 총알의 생존 여부
	boolean blive;
	// 몬스터의 생존 여부
	boolean live;
	
	int bbc;
	
	PlaySound ps;
	
	// 충돌처리용 맵
	Map map;
	
	// 몬스터 클래스 초기화
	public Monster(MainCanvas mc, int x, int y, Map map, Hero hero)
	{
		this.mc = mc;
		
		frame = 0;
		direction = false;
		control = false;
		live = true;
		
		this.x = (byte) (def = x);
		this.y = (byte) y;
		
		this.map = map;
		this.hero = hero;

		ps = new PlaySound(0);
		ps.start();
	}
	
	// 몬스터를 그림
	public void Draw(Graphics g)
	{
		if(live)
		{
			if(!direction)
				if(!blive)
					g.drawImage(Common.monr[frame], Configs.x + (x * 25) - (map.x * 25), 3 + Configs.y + (y * 25), MainCanvas.G_TL);
				else
					g.drawImage(Common.monr[frame], Configs.x + (x * 25) - (map.x * 25), 3 + Configs.y + (y * 25), MainCanvas.G_TL);
			else
				if(!blive)
					g.drawImage(Common.monl[frame], Configs.x + (x * 25) - (map.x * 25), 3 + Configs.y + (y * 25), MainCanvas.G_TL);
				else
					g.drawImage(Common.monl[frame], Configs.x + (x * 25) - (map.x * 25), 3 + Configs.y + (y * 25), MainCanvas.G_TL);
			
			if(control)
			{
				if(!direction)
					g.drawImage(Common.monctrl, Configs.x + (x * 25) - (map.x * 25) + 2, 3 + Configs.y + (y * 25) - 5, MainCanvas.G_TL);
				else
					g.drawImage(Common.monctrl, Configs.x + (x * 25) - (map.x * 25) + 9, 3 + Configs.y + (y * 25) - 5, MainCanvas.G_TL);
			}
			
			if(blive)
				bullet.draw(g);
		
			count++;
		}
		else
			g.drawImage(Common.mondead, Configs.x + (x * 25) - (map.x * 25), 18 + Configs.y + (y * 25), MainCanvas.G_TL);
	}
	
	public void move()
	{
		if(live)
		{
			if(!control)
			{				
				if(!Lib.msCrash(hero, this, map, direction))
				{
					if(!blive)
					{
						if(bbc>=15)
						{
							bullet = new Bullet(mc, direction, map);
							blive = true;
							bullet.x = (short)(this.x * 25);
							bullet.y = (short)this.y;
							bbc = 0;
							return;
						}
					}
					
					if(bcount >= 14)
					{
						blive = false;
						bcount = 0;
					}
					else
					{
						if(blive)
						{
							bullet.shotting();
							if(!Lib.hbCrash(hero, bullet, map))
							{
								hero.hp -= 3;
								blive = false;
							}
							bcount++;
						}
					}
					bbc++;
					return;
				}
				if(blive)
					if(bcount >= 14)
					{
						blive = false;
						bcount = 0;
					}
					else
					{
						bullet.shotting();
						if(!Lib.hbCrash(hero, bullet, map))
						{
							hero.hp -= 3;
							blive = false;
						}
						bcount++;
					}
				
				if(count >= 10)
				{
					if(!direction)
					{
						if(!Lib.Crashcheck(x + 1, y, map))
							if(Lib.Crashcheck(x + 1, y + 1, map))
									x++;
							else
								direction = true;
						else
							direction = true;
						if(x - def >= 2)
							direction = true;
					}
					else
					{
						if(!Lib.Crashcheck(x - 1, y, map))
							if(Lib.Crashcheck(x - 1, y + 1, map))
								x--;
							else
								direction = false;
						else
							direction = false;
						if(def - x >= 2)
							direction = false;
					}
					
					count = 0;
				}
				else
				{
					if(count >= 6)
					{
						if(frame == 2)
							frame = 1;
						else
							frame = 2;
					}
				}
			}
			else
			{
				blive = false;
			}
			bbc++;
		}
		else
		{
			if(control == true)
			{
				hero.skenable = false;
				control = false;
			}
		}
	}

	public void Key()
	{
		if(mc.KeyPress == 1)
		{
			switch(mc.nKey)
			{
			case KEY_FIRE:
			case KEY_NUM5:
				if(live)
				{
					if(count>=5)
					{
						if(control == true)
						{
							hero.skenable = false;
							control = false;
						}    
						else if(hero.sk == 3 && hero.skenable == false)
						{
							if(hero.sp >= 10)
								if(!Lib.hmCrash(hero, this, map))
								{
									hero.skenable = true;
									control = true;
									hero.sp -= 4;
									ps.play("sound/control.mmf", false);
								}
						}
					}
				}
				break;
			case KEY_LEFT:
			case KEY_NUM4:
				if(control == true)
				{
					if(count>=2)
					{
						if(!Lib.Crashcheck(x - 1, y, map))
							if(Lib.Crashcheck(x - 1, y + 1, map))
									x -= 1;
						if(frame == 2)
							frame = 1;
						else
							frame = 2;
						count=0;
					}
					direction = true;
				}
				break;
			case KEY_RIGHT:
			case KEY_NUM6:
				if(control == true)
				{
					if(count>=2)
					{
						if(!Lib.Crashcheck(x + 1, y, map))
							if(Lib.Crashcheck(x + 1, y + 1, map))
									x += 1;
						if(frame == 2)
							frame = 1;
						else
							frame = 2;
						count=0;
					}
					direction = false;
				}
				break;
			}
		}
	}
}