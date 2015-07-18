import javax.microedition.lcdui.*;

//
// 장식물 클래스 - Play에서 사용
//
public class Deco extends Define
{
	MainCanvas mc;
	Map map;
	
	short x, y;
	byte type;
	
	public Deco(MainCanvas mc, Map map, int num, int x, int y)
	{
		this.mc = mc;
		this.map = map;
		type = (byte)num;
		this.x = (short)x;
		this.y = (short)y;
	}
	
	public void Draw(Graphics g)
	{
		if(Configs.deco)
		{
			switch(type)
			{
			case 0:
				g.drawImage(Common.light, Configs.x + (x * 25) - (map.x * 25), 3 + Configs.y + (y * 25), MainCanvas.G_TL);
				break;
			case 1:
				g.drawImage(Common.dead, Configs.x + (x * 25) - (map.x * 25), 3 + Configs.y + (y * 25), MainCanvas.G_TL);
				break;
			case 2:
				g.drawImage(Common.com, Configs.x + (x * 25) - (map.x * 25), 3 + Configs.y + (y * 25), MainCanvas.G_TL);
				break;
			case 3:
				g.drawImage(Common.pipe, Configs.x + (x * 25) - (map.x * 25), 3 + Configs.y + (y * 25), MainCanvas.G_TL);
				break;
			}
		}
	}
}
