import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.Graphics;

//
// �������̽� Ŭ���� - Play���� ���
//
public class Iface extends Define{
	Image hp; //HP
	Image sp; //SP
	Image[] sk1; //ù��° ��ų
	Image[] sk2;  // �ι�° ��ų
	Image[] sk3; // ����° ��ų
	
	Hero hero;
	
	public Iface(Hero hero)
	{
		try
		{
			hp = Image.createImage("inf/hp.png");
			sp = Image.createImage("inf/sp.png");
			
			sk1 = new Image[2];
			sk2 = new Image[2];
			sk3 = new Image[2];
			
			sk1[0] = Image.createImage("inf/in.png");
			sk2[0] = Image.createImage("inf/in2.png");
			sk3[0] = Image.createImage("inf/in3.png");
			
			sk1[1] = Image.createImage("inf/ina.png");
			sk2[1] = Image.createImage("inf/in2a.png");
			sk3[1] = Image.createImage("inf/in3a.png");
		}
		catch(Exception ex)
		{
		
		}
		
		this.hero = hero;
	}
	
	// �׸� �׸��� �޼���
	public void Draw(Graphics g)
	{
		g.setColor(0,0,0);         
		g.fillRect(Configs.x + 0,Configs.y + 148,176,30);  //��ü �������̽�
		
		g.setColor(0xff0000);
		g.drawImage(hp,Configs.x + 2,Configs.y + 137,Graphics.LEFT|Graphics.TOP);					 // HP�׸���
		g.drawRect(Configs.x + 23, Configs.y + 137, 50, 10);										 // HP�� �׸���
		g.fillRect(Configs.x + 23, Configs.y + 137, hero.hp * 5, 10);								 // HP�� �׸���
		g.drawImage(sp,Configs.x + 2,Configs.y + 157,Graphics.LEFT|Graphics.TOP);					 // SP �׸���
		g.setColor(0x0000ff);
		g.drawRect(Configs.x + 23, Configs.y + 157, 50, 10);										 // SP�� �׸���
		g.fillRect(Configs.x + 23, Configs.y + 157, hero.sp, 10);								   	 // SP�� �׸���
		
		switch(hero.sk)
		{
		case 1:
			g.drawImage(sk1[1], Configs.x + 77, Configs.y + 137, MainCanvas.G_TL);					 // ù��° ��ų �׸���
			g.drawImage(sk2[0], Configs.x + 110, Configs.y + 137, MainCanvas.G_TL);					 // �ι�° ��ų �׸���
			g.drawImage(sk3[0], Configs.x + 143, Configs.y + 137, MainCanvas.G_TL);					 // ����° ��ų �׸���
			break;
		case 2:
			g.drawImage(sk1[0], Configs.x + 77, Configs.y + 137, MainCanvas.G_TL);					 // ù��° ��ų �׸���
			g.drawImage(sk2[1], Configs.x + 110, Configs.y + 137, MainCanvas.G_TL);					 // �ι�° ��ų �׸���
			g.drawImage(sk3[0], Configs.x + 143, Configs.y + 137, MainCanvas.G_TL);					 // ����° ��ų �׸���
			break;
		case 3:	
			g.drawImage(sk1[0], Configs.x + 77, Configs.y + 137, MainCanvas.G_TL);					 // ù��° ��ų �׸���
			g.drawImage(sk2[0], Configs.x + 110, Configs.y + 137, MainCanvas.G_TL);					 // �ι�° ��ų �׸���
			g.drawImage(sk3[1], Configs.x + 143, Configs.y + 137, MainCanvas.G_TL);					 // ����° ��ų �׸���
			break;	
		}
		
	}
	
}
