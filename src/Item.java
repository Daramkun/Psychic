import javax.microedition.lcdui.*;
import java.io.DataOutputStream;
import com.xce.io.FileOutputStream;

//
// ������ Ŭ���� - Play���� ���
//
public class Item extends Define
{
	byte type;
	
	byte x; //������ ��ǥ
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
//	������������������������������������������������������������������
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
				mc.play.msgContent1 = (page + 1) + "�� ������ ������ϴ�.";
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
					
					mc.play.msgContent1 = "����Ǿ����ϴ�.";
				}
				catch(Exception e) 
				{
					mc.play.msgContent1 = "�������� ���Ͽ����ϴ�.";
				}
				break;
			case 2:
				switch(page)
				{
				case 0:
					mc.play.msgName = "����";
					mc.play.msgContent1 = "���������ΰ�...";
					mc.play.msgContent2 = "�����̵��� ��߰ڴ�.";
					break;
				case 1:
					mc.play.msgName = "����";
					mc.play.msgContent1 = "�溸�ⱸ��.";
					mc.play.msgContent2 = "������ ����ؾ߰ڴ�.";
					break;
				case 2:
					mc.play.msgName = "����";
					mc.play.msgContent1 = "�տ� �ִ°� ���ΰ�...";
					mc.play.msgContent2 = "�� ������ �̿�����.";
					break;
				case 3:
					mc.play.msgName = "����";
					mc.play.msgContent1 = "�ſ��ΰ�...";
					mc.play.msgContent2 = "�����̵��� ��߰ڴ�.";
					break;
				case 4:
					mc.play.msgName = "����";
					mc.play.msgContent1 = "�����̴�!";
					mc.play.msgContent2 = "������ �̿��ؾ���.";
					break;
				case 5:
					mc.play.msgName = "����";
					mc.play.msgContent1 = "�����?";
					mc.play.msgContent2 = "�����ؼ� ��������.";
					break;
				case 6:
					mc.play.msgName = "����";
					mc.play.msgContent1 = "���̱���.";
					mc.play.msgContent2 = "���� ȭ��ǥ�� ����.";
					break;
				}
				break;
			}
			
			ilive = false;
		}
	}
}