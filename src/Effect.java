import javax.microedition.lcdui.*;

//
// 이펙트 클래스 - Play에서 사용
//
public class Effect extends Define
{
	public Hero hero;
	public Map map;
	public Graphics g;
	
	Image[] left;
	Image[] right;
	
	public Effect()
	{		
		left = new Image[4];
		right = new Image[4];
		
		try
		{
			for(int i=0;i<4;i++)
			{
				right[i] = Image.createImage("hero/skill/skill" + i + ".png");
			}

			for(int i=0;i<4;i++)
			{
				left[i] = Image.createImage("hero/skill/skill" + i + "a.png");
			}
		}
		catch(Exception ex)
		{
			
		}
	}
	
	public void Draw(int frame)
	{
		try
		{
			if(!hero.direction)
			{
				g.drawImage(right[frame], Configs.x + (hero.x * 25) - 3, Configs.y + (hero.y * 25) + 3, MainCanvas.G_TL);
			}
			else
			{
				g.drawImage(left[frame], Configs.x + (hero.x * 25) - 3, Configs.y + (hero.y * 25) + 3, MainCanvas.G_TL);
			}
		}
		catch(Exception ex)
		{
			
		}
	}
}
