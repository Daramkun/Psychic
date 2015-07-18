import javax.microedition.lcdui.*;

//
// NPC 클래스 - Play에서 사용
//
public class Npc extends Define
{
	MainCanvas mc;
	Image img1;
	Image img2;
	public boolean direction;
	byte x, y;
	public boolean live;
	
	public Npc(MainCanvas mc, int x, int y, boolean walk)
	{
		try
		{
			img1 = Image.createImage("npc/npc0.png");
			img2 = Image.createImage("npc/npc0a.png");
		}
		catch(Exception ex)
		{
			
		}
		
		this.mc = mc;
		this.x = (byte) x;
		this.y = (byte) y;
	}
	
	public void Draw(Graphics g)
	{
		if(live)
		{
			if(!direction)
			{
				g.drawImage(img1, Configs.x + (x * 25), Configs.y + 4 + (y * 25), MainCanvas.G_TL);
			}
			else
			{
				g.drawImage(img2, Configs.x + (x * 25), Configs.y + 4 + (y * 25), MainCanvas.G_TL);
			}
		}
	}
}
