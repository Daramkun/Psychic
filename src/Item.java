import javax.microedition.lcdui.*;
import java.io.DataOutputStream;
import com.xce.io.FileOutputStream;

//
// 아이템 클래스 - Play에서 사용
//
public class Item extends Define
{
	byte type;
	
	byte x; //아이템 좌표
	byte y;
	
	MainCanvas mc;
	Hero hero;
	Map map;
	
	boolean ilive;
	
	boolean ud;
	int count;
	
	int page;

	public Item(MainCanvas mc, Hero hero, Map map, int type, int page, int x, int y)
	{	
		this.type = (byte) type;
		
		this.hero = hero;
		this.map = map;
		this.mc = mc;
		
		this.x = (byte) x;
		this.y = (byte) y;
		
		ilive = true;
		this.page = page;
	}
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	public void Draw(Graphics g)
	{
		switch(type)
		{
		case 0:
			if(ud)
			{
				g.drawImage(Common.itext, Configs.x + (x * 25) - (map.x * 25) + 5, 3 + Configs.y + (y * 25) + 4, MainCanvas.G_TL);
			}
			else
			{
				g.drawImage(Common.itext, Configs.x + (x * 25) - (map.x * 25) + 5, 3 + Configs.y + (y * 25) + 6, MainCanvas.G_TL);
			}
			break;
		case 1:
			if(ud)
			{
				g.drawImage(Common.isave, Configs.x + (x * 25) - (map.x * 25) + 5, 3 + Configs.y + (y * 25) + 4, MainCanvas.G_TL);
			}
			else
			{
				g.drawImage(Common.isave, Configs.x + (x * 25) - (map.x * 25) + 5, 3 + Configs.y + (y * 25) + 6, MainCanvas.G_TL);
			}
			break;
		case 2:
			if(ud)
			{
				g.drawImage(Common.ihelp, Configs.x + (x * 25) - (map.x * 25), 3 + Configs.y + (y * 25) - 1, MainCanvas.G_TL);
			}
			else
			{
				g.drawImage(Common.ihelp, Configs.x + (x * 25) - (map.x * 25), 3 + Configs.y + (y * 25) + 1, MainCanvas.G_TL);
			}
			break;
		}
		
		if(count >= 10)
		{
			ud = !ud;
			count = 0;
		}
		else
			count++;
		
		if(!Lib.hiCrash(hero, this, map))
		{
			switch(type)
			{
			case 0:
				Configs.pages[page] = true;
				mc.play.msgContent1 = (page + 1) + "번 문서를 얻었습니다.";
				break;
			case 1:
				try
				{			
					FileOutputStream os = new FileOutputStream("save.dat");
					DataOutputStream dos = new DataOutputStream(os);

					dos.writeInt(hero.hp);
					dos.writeInt(hero.sp);
					dos.writeInt(map.stage);
					System.out.println(map.stage);
					
					for(int i = 0; i < 10; i++)
					{
						dos.writeBoolean(Configs.pages[i]);
					}
					
					dos.close();
					
					dos = null;
					os = null;
					
					System.gc();
					
					mc.play.msgContent1 = "저장되었습니다.";
				}
				catch(Exception e) 
				{
					mc.play.msgContent1 = "저장하지 못하였습니다.";
				}
				break;
			case 2:
				switch(page)
				{
				case 0:
					mc.play.msgName = "리사";
					mc.play.msgContent1 = "낭떠러지인가...";
					mc.play.msgContent2 = "순간이동을 써야겠다.";
					break;
				case 1:
					mc.play.msgName = "리사";
					mc.play.msgContent1 = "경보기구나.";
					mc.play.msgContent2 = "투명을 사용해야겠다.";
					break;
				case 2:
					mc.play.msgName = "리사";
					mc.play.msgContent1 = "앞에 있는건 덫인가...";
					mc.play.msgContent2 = "저 군인을 이용하자.";
					break;
				case 3:
					mc.play.msgName = "리사";
					mc.play.msgContent1 = "거울인가...";
					mc.play.msgContent2 = "순간이동을 써야겠다.";
					break;
				case 4:
					mc.play.msgName = "리사";
					mc.play.msgContent1 = "군인이다!";
					mc.play.msgContent2 = "투명을 이용해야지.";
					break;
				case 5:
					mc.play.msgName = "리사";
					mc.play.msgContent1 = "압축기?";
					mc.play.msgContent2 = "조심해서 지나가자.";
					break;
				case 6:
					mc.play.msgName = "리사";
					mc.play.msgContent1 = "문이구나.";
					mc.play.msgContent2 = "위쪽 화살표로 들어가자.";
					break;
				}
				break;
			}
			
			ilive = false;
		}
	}
}