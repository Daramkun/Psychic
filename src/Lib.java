import javax.microedition.lcdui.*;

//
// 라이브러리 - 충돌 처리, 퍼센트 구하기, 대화 출력 함수
//
public class Lib
{
	// 대화 내용 출력. 그래픽스 변수, 말하는 사람 이름, 그리고 대화 내용이 들어간다.
	public static boolean Message(Graphics g, Image img, String name, String content1, String content2)
	{
		if(name == "" && content1 == "" && content2 == "") return false;
		
		if(name == "") name = "SYSTEM";

		if(img != null)
			g.drawImage(img, Configs.x, Configs.y, MainCanvas.G_TL);
		
		g.setColor(0x000000);
		g.fillRect(Configs.x, Configs.y + 120, Configs.x + 176, Configs.y + 58);
		
		g.setColor(0xffffff);
		g.drawLine(Configs.x, Configs.y + 120, Configs.x + 176, Configs.y + 120);
		
		g.setColor(0x00ff00);
		g.drawString("[ " + name +  " ]", Configs.x + 4, Configs.y + 122, Graphics.TOP | Graphics.LEFT);
		
		g.setColor(0xffffff);
		
		g.drawString(content1, Configs.x + 10, Configs.y + 142, Graphics.TOP | Graphics.LEFT);
		g.drawString(content2, Configs.x + 10, Configs.y + 156, Graphics.TOP | Graphics.LEFT);
		
		return true;
	}
	
	// 객체와 벽의 충돌 처리
	public static boolean Crashcheck(int x, int y, Map map)
	{
		if(x <= -1 || x >= map.width)
			return true;
		if(map.map[y][x] == 0)
			return false;
		else
			return true;
	}
	
	// 몬스터와 주인공의 충돌처리
	public static boolean hmCrash(Hero hero, Monster mon, Map map)
	{
		if(hero.x + map.x == mon.x && hero.y == mon.y)
			return false;
		else
			return true;
	}
	
	// 주인공과 총알의 충돌 처리
	public static boolean hbCrash(Hero hero, Bullet bullet, Map map)
	{
		if(((hero.x * 25) + (map.x * 25) <= bullet.x + 25 &&
				bullet.x <= (hero.x * 25) + (map.x * 25) + 25) && (hero.y == bullet.y))
			return false;
		else
			return true;
	}
	
	// 몬스터와 총알의 충돌 처리
	public static boolean mbCrash(Monster mon, Bullet bullet)
	{
		if((mon.x <= bullet.x + 5 && bullet.x <= mon.x + 15) && (mon.y == bullet.y))
			return false;
		else
			return true;
	}
	
	// 주인공과 아이템의 충돌 처리
	public static boolean hiCrash(Hero hero, Item item, Map map)
	{
		if(hero.x + map.x == item.x && hero.y == item.y)
			return false;
		else
			return true;
	}
	
	// 주인공과 개체의 충돌 처리
	public static boolean hoCrash(Hero hero, Objects obj, Map map)
	{
		if(hero.x + map.x == obj.x && hero.y == obj.y)
			return false;
		else
			return true;
	}
	
	// 주인공이 적의 시야에 들어가는지 검사
	public static boolean msCrash(Hero hero, Monster mon, Map map, boolean direction)
	{
		if(hero.hp > 0)
		{
			if(!direction)	// 몬스터가 오른쪽을 보고 있을 때
			{
				if((hero.x + map.x - 1 == mon.x || hero.x + map.x - 2 == mon.x) && (hero.y == mon.y))
				{
					if(hero.sk == 2)
					{
						if(hero.skenable && hero.mc.nKey != 0)
							return false;
						else if(!hero.skenable)
							return false;
					}
					else
					{
						return false;
					}
				}
				return true;
			}
			else			// 몬스터가 왼쪽을 보고 있을 때
				if((hero.x + map.x + 1 == mon.x || hero.x + map.x + 2 == mon.x) && (hero.y == mon.y))
				{
					if(hero.sk == 2)
					{
						if(hero.skenable && hero.mc.nKey != 0)
							return false;
						else if(!hero.skenable)
							return false;
					}
					else
					{
						return false;
					}
				}
				return true;
		}
		else
		{
			return true;
		}
	}
	
	// 몬스터와 개체의 충돌
	public static boolean moCrash(Monster mon, Objects obj)
	{
		if(mon.x == obj.x && mon.y == obj.y)
			return false;
		else
			return true;
	}
}
