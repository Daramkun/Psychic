import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

//
// 보스 클래스 - Play에서 사용
//
public class Boss extends Define
{
	MainCanvas mc;
	boolean direction;
	public byte x, y;
	public boolean live;
	Image[] boss;
	
	public Boss(MainCanvas mc, int x, int y, boolean walk)
	{
		this.mc = mc;
		this.x = (byte) x;
		this.y = (byte) y;
		
		try
		{
			boss = new Image[2];
			boss[0] = Image.createImage("boss/boss0.png");
			boss[1] = Image.createImage("boss/boss0a.png");
		}
		catch(Exception ex)
		{
			
		}
	}
	
	public void Draw(Graphics g)
	{
		if(live)
		{
			if(!direction)
			{
				g.drawImage(boss[0], Configs.x + (x * 25), Configs.y + 4 + (y * 25), MainCanvas.G_TL);
			}
			else
			{
				g.drawImage(boss[1], Configs.x + (x * 25), Configs.y + 4 + (y * 25), MainCanvas.G_TL);
			}
		}
	}
}
