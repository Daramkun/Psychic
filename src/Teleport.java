import javax.microedition.lcdui.*;

//
// 텔레포트 클래스 - Play에서 사용 - Hero와 연동
//
public class Teleport extends Define
{
	
	MainCanvas mc;
	Hero hero;
	Map map;
	public int x,y;
	int count;
	PlaySound ps;
	
	public Teleport(MainCanvas mc, Hero hero, Map map)
	{
		this.mc = mc;
		
		this.hero = hero;
		this.map = map;
		
		x = hero.x;
		y = hero.y;
		ps = new PlaySound(0);
		ps.start();
	}
	
	public void Draw(Graphics g)
	{
		if(hero.skenable && hero.sk == 1)
		{
			g.setColor(240, 0, 0);
			g.fillRoundRect((x * 25) + 8 + Configs.x, 13 + (y * 25) + Configs.y, 5, 5, 5, 5);
		}
	}
	
	public void skill()
	{		
		switch(mc.nKey)
		{
		case KEY_NUM2: 
		case KEY_UP:
			if(y - 1 >= 0)
				if(hero.sk==1 && hero.skenable)
					if(!Lib.Crashcheck(map.x + x, y - 1, map))
						y -= 1;
				break;
		case KEY_NUM8:
		case KEY_DOWN:
			if(y + 1 <= 4)
				if(hero.sk==1 && hero.skenable)
					if(!Lib.Crashcheck(map.x + x, y + 1, map))
						y += 1;
			break;
		case KEY_NUM4:
		case KEY_LEFT:
			if(x - 1 >= 0)
				if(hero.sk==1 && hero.skenable)
					if(!Lib.Crashcheck(map.x + x - 1, y, map))
						x -= 1;
			break;
		case KEY_NUM6:
		case KEY_RIGHT:
			if(x  + 1 <= 6)
				if(hero.sk==1 && hero.skenable)
					if(!Lib.Crashcheck(map.x + x + 1, y, map))
						x += 1;
			break;
		case KEY_NUM5:
		case KEY_FIRE:
			if(mc.KeyPress == 1)
			{
				if(hero.sk==1)
				{
					if(!hero.skenable)
					{
						if(hero.sp >= 2)
						{
							hero.skenable = true;
							x = hero.x;
							y = hero.y;
							break;
						}
					}
					else
					{
						boolean cant = true;
						
						for(int i=0;i<5;i++)
						{
							if(map.map[i][x + map.x] == 2)
								cant = false;
						}
						
						boolean glass = false;
						int maxy = 0;
						
						for(int i = 0 ; i < 5 ; i++)
						{
							if(map.map[i][x + map.x] == 3)
							{
								glass = true;
								cant = true;
							}
						}
						
						if(glass)
						{
							x += x - hero.x;
	
							if(y >= 2)
							{
								for(int i = 3 ; i >= 0 ; i--)
								{
									if(map.map[i][x + map.x] == 0)
									{
										maxy = i;
										break;
									}
								}
							}
							else
							{
								for(int i = 0 ; i <= 3 ; i++)
								{
									if(map.map[i][x + map.x] == 0)
									{
										maxy = i;
										break;
									}
								}
							}
						}
						else
							maxy = y;
						
						if(cant)
						{
							ps.play("sound/teleport.mmf", false);
							
							if(map.x == 0)
							{
								if(x <= 3)
								{
									hero.x = (byte) x;
									hero.y = (byte) maxy;
								}
								else
								{
									hero.x = 3;
									hero.y = (byte) maxy;
									map.x = (byte) (x - 3);
								}
							}
							else if(map.x >= map.width - 3)
							{
								if(x <= 3)
								{
									hero.x = (byte) x;
									hero.y = (byte) maxy;
								}
								else
								{
									hero.x = 3;
									hero.y = (byte) maxy;
									map.x -= x  - 3;
								}
							}
							else
							{
								hero.x = 3;
								hero.y = (byte) maxy;
								if(hero.x > x)
									map.x -= 3 - x;
								else if(hero.x < x)
									map.x += x  - 3;
							}
							hero.sp -= 2;
						}
					}
					hero.skenable = false;
					break;
				}
			}
			break;
		}
	}
}
