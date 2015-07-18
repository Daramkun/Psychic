import javax.microedition.lcdui.*;

//
// ���� ���� Ŭ���� - Play���� ���
//
public class Gameover extends Define 
{
	Image img1; //���ӿ��� �̹���
	Hero hero;
	
	byte count = 0;
	
	MainCanvas mc;
	
	public Gameover(MainCanvas mc,Hero hero)
	{
		this.hero = hero;
		
		try
		{
			img1 = Image.createImage("etc/gameover.png");			
		}
		catch(Exception ex)
		{
			
		}
		
		this.mc = mc;
	}
	
	public void Draw(Graphics g)
	{
		if(hero.hp <= 0)
		{
			g.drawImage(img1,Configs.x + 20,Configs.y + 50,Graphics.LEFT|Graphics.TOP);
			
			if(count >= 30)
			{
				mc.GameState(MENU);
				mc.play = null;
				System.gc();
			}
			else
			{
				count++;
			}
		}
	}
}
