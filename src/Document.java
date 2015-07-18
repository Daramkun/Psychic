import javax.microedition.lcdui.*;

//
// ��ť��Ʈ Ŭ���� - Gmenu���� ���
//
public class Document extends Define
{
	MainCanvas mc;
	Play play;
	Gmenu gm;
	Image img;
	
	byte cursor = 1;
	
	String[] one = new String[15];
	String[] two = new String[15];
	String[] three = new String[15];
	String[] four = new String[15];
	String[] five = new String[15];
	String[] six = new String[15];
	String[] seven = new String[15];
	String[] eight = new String[15];
	String[] nine = new String[15];
	String[] ten = new String[15];
	
	Image text;
	Image cur;
	
	byte printline = 0;
	final String NON_DOC = "���� ���� ����";
	
	public Document(MainCanvas mc, Play play, Gmenu gm)
	{
		try
		{
			img = Image.createImage("menu/menu2.png");
			text = Image.createImage("item/text.png");
			cur = Image.createImage("etc/tcur.png");
		}
		catch(Exception ex)
		{
			
		}
		
		this.mc = mc;
		this.play = play;
		this.gm = gm;
		InitText();
	}
	
	public void Draw(Graphics g)
	{
		g.drawImage(img, Configs.x, Configs.y, MainCanvas.G_TL);
		
		g.setColor(0x000000);
		g.fillRect(Configs.x + 35, Configs.y, 150, 180);
		
		String tp = "";
		
		switch(cursor)
		{
		case 1:
			if(Configs.pages[0])
				tp = "���� ���� ����-01";
			else
				tp = NON_DOC;
			g.drawImage(cur, Configs.x + 40, Configs.y + 22, MainCanvas.G_TL);
			break;
		case 2:
			if(Configs.pages[1])
				tp = "�ǹ��� ����";
			else
				tp = NON_DOC;
			g.drawImage(cur, Configs.x + 68, Configs.y + 22, MainCanvas.G_TL);
			break;
		case 3:
			if(Configs.pages[2])
				tp = "���� ���� ����-02";
			else
				tp = NON_DOC;
			g.drawImage(cur, Configs.x + 96, Configs.y + 22, MainCanvas.G_TL);
			break;
		case 4:
			if(Configs.pages[3])
				tp = "���� ���� ����-03";
			else
				tp = NON_DOC;
			g.drawImage(cur, Configs.x + 120, Configs.y + 22, MainCanvas.G_TL);
			break;
		case 5:
			if(Configs.pages[4])
				tp = "ȸ�Ƿ�";
			else
				tp = NON_DOC;
			g.drawImage(cur, Configs.x + 144, Configs.y + 22, MainCanvas.G_TL);
			break;
		case 6:
			if(Configs.pages[5])
				tp = "������������";
			else
				tp = NON_DOC;
			g.drawImage(cur, Configs.x + 40, Configs.y + 46, MainCanvas.G_TL);
			break;
		case 7:
			if(Configs.pages[6])
				tp = "��Ƽ�� ���� ����";
			else
				tp = NON_DOC;
			g.drawImage(cur, Configs.x + 68, Configs.y + 46, MainCanvas.G_TL);
			break;
		case 8:
			if(Configs.pages[7])
				tp = "������ħ��";
			else
				tp = NON_DOC;
			g.drawImage(cur, Configs.x + 96, Configs.y + 46, MainCanvas.G_TL);
			break;
		case 9:
			if(Configs.pages[8])
				tp = "���翡��";
			else
				tp = NON_DOC;
			g.drawImage(cur, Configs.x + 120, Configs.y + 46, MainCanvas.G_TL);
			break;
		case 10:
			if(Configs.pages[9])
				tp = "�ڵ�� Mr. E�� ���ؼ�";
			else
				tp = NON_DOC;
			g.drawImage(cur, Configs.x + 144, Configs.y + 46, MainCanvas.G_TL);
			break;
		}

		g.setColor(240,240,240);
		g.fillRect(Configs.x + 44, Configs.y + 5, 120, 15);
		
		g.setColor(0x000000);
		g.drawString(tp, Configs.x + 46, Configs.y + 7, MainCanvas.G_TL);
		
		g.drawImage(text, Configs.x + 44, Configs.y + 26, MainCanvas.G_TL);
		g.drawImage(text, Configs.x + 72, Configs.y + 26, MainCanvas.G_TL);
		g.drawImage(text, Configs.x + 100, Configs.y + 26, MainCanvas.G_TL);
		g.drawImage(text, Configs.x + 124, Configs.y + 26, MainCanvas.G_TL);
		g.drawImage(text, Configs.x + 148, Configs.y + 26, MainCanvas.G_TL);
			
		g.drawImage(text, Configs.x + 44, Configs.y + 50, MainCanvas.G_TL);
		g.drawImage(text, Configs.x + 72, Configs.y + 50, MainCanvas.G_TL);
		g.drawImage(text, Configs.x + 100, Configs.y + 50, MainCanvas.G_TL);
		g.drawImage(text, Configs.x + 124, Configs.y + 50, MainCanvas.G_TL);
		g.drawImage(text, Configs.x + 148, Configs.y + 50, MainCanvas.G_TL);

		g.setColor(240, 240, 240);
		
		switch(cursor)
		{
		case 1:
			if(Configs.pages[0])
				for(int i=0;i<7;i++)
					g.drawString(one[printline + i], Configs.x + 40, Configs.y + 70 + (i * 12), MainCanvas.G_TL);
			else
				g.drawString(NON_DOC,Configs.x + 40,Configs.y + 70,MainCanvas.G_TL);
			break;
		case 2:
			if(Configs.pages[1])
				for(int i=0;i<7;i++)
					g.drawString(two[printline + i], Configs.x + 40, Configs.y + 70 + (i * 12), MainCanvas.G_TL);
			else
				g.drawString(NON_DOC,Configs.x + 40,Configs.y + 70,MainCanvas.G_TL);
			break;
		case 3:
			if(Configs.pages[2])
				for(int i=0;i<7;i++)
					g.drawString(three[printline + i], Configs.x + 40, Configs.y + 70 + (i * 12), MainCanvas.G_TL);
			else
				g.drawString(NON_DOC,Configs.x + 40,Configs.y + 70,MainCanvas.G_TL);
			break;
		case 4:
			if(Configs.pages[3])
				for(int i=0;i<7;i++)
					g.drawString(four[printline + i], Configs.x + 40, Configs.y + 70 + (i * 12), MainCanvas.G_TL);
			else
				g.drawString(NON_DOC,Configs.x + 40,Configs.y + 70,MainCanvas.G_TL);
			break;
		case 5:
			if(Configs.pages[4])
				for(int i=0;i<7;i++)
					g.drawString(five[printline + i], Configs.x + 40, Configs.y + 70 + (i * 12), MainCanvas.G_TL);
			else
				g.drawString(NON_DOC,Configs.x  +40,Configs.y + 70,MainCanvas.G_TL);
			break;
		case 6:
			if(Configs.pages[5])
				for(int i=0;i<7;i++)
					g.drawString(six[printline + i], Configs.x + 40, Configs.y + 70 + (i * 12), MainCanvas.G_TL);
			else
				g.drawString(NON_DOC,Configs.x + 40,Configs.y + 70,MainCanvas.G_TL);
			break;
		case 7:
			if(Configs.pages[6])
				for(int i=0;i<7;i++)
					g.drawString(seven[printline + i], Configs.x + 40, Configs.y + 70 + (i * 12), MainCanvas.G_TL);
			else
				g.drawString(NON_DOC,Configs.x + 40,Configs.y + 70,MainCanvas.G_TL);
			break;
		case 8:
			if(Configs.pages[7])
				for(int i=0;i<7;i++)
					g.drawString(eight[printline + i], Configs.x + 40, Configs.y + 70 + (i * 12), MainCanvas.G_TL);
			else
				g.drawString(NON_DOC,Configs.x + 40,Configs.y + 70,MainCanvas.G_TL);
			break;
		case 9:
			if(Configs.pages[8])
				for(int i=0;i<7;i++)
					g.drawString(nine[printline + i], Configs.x + 40, Configs.y + 70 + (i * 12), MainCanvas.G_TL);
			else
				g.drawString(NON_DOC,Configs.x + 40,Configs.y + 70,MainCanvas.G_TL);
			break;
		case 10:
			if(Configs.pages[9])
				for(int i=0;i<7;i++)
					g.drawString(ten[printline + i], Configs.x + 40, Configs.y + 70 + (i * 12), MainCanvas.G_TL);
			else
				g.drawString(NON_DOC,Configs.x + 40,Configs.y + 70,MainCanvas.G_TL);
			break;
		}
		
		g.drawString(printline + "/" + (15 - 7), 
				Configs.x + 100,
				Configs.y + 155, MainCanvas.G_TL);
	}
	
	public void Key()
	{
		switch(mc.nKey)
		{
		case KEY_UP:
		case KEY_NUM2:
			if(printline != 0)
				printline--;
			break;
		case KEY_DOWN:
		case KEY_NUM8:
			if(printline != 15 - 7)
				printline++;
			break;
		case KEY_LEFT:
		case KEY_NUM4:
			if(cursor != 1)
				cursor --;
			printline = 0;
			break;
		case KEY_RIGHT:
		case KEY_NUM6:
			if(cursor != 10)
				cursor ++;
			printline = 0;
			break;
		case KEY_CLR:
			play.gdmode = false;
			break;
		}
	}
	
	public void InitText()
	{
		InitOne();
		InitTwo();
		InitThree();
		InitFour();
		InitFive();
		InitSix();
		InitSeven();
		InitEight();
		InitNine();
		InitTen();
	}
	
	public void InitOne()
	{
		one[0] = "���� �츮�� ���縦";
		one[1] = "�������� 20���� ��";
		one[2] = "���ߴ�.";
		one[3] = "���� �׳��� �ʴɷ���";
		one[4] = "����� �ʿ��� ������";
		one[5] = "�ſ� �����Ͽ���.";
		one[6] = "���� ������ Ȱ����";
		one[7] = "�⿣ �������� �׳�";
		one[8] = "�� ���ؼ� �� ������ ";
		one[9] = "���簡 �����ϴٸ�";
		one[10] = "��������ε� Ȱ����";
		one[11] = "������ �� ����.";
		one[12] = "";
		one[13] = "";
		one[14] = "";
	}
	
	public void InitTwo()
	{
		two[0] = "���� �׳ฦ �����ϰ�";
		two[1] = "�ִ� ���ȿ� ���� ���";
		two[2] = "�ڰ� �߻��Ͽ���.";
		two[3] = "������ 3���̳� �װ�";
		two[4] = "�� ���� ���� ���ȿ���";
		two[5] = "1���� �׾���.";
		two[6] = "�̷��� �����ϸ鼭��";
		two[7] = "�� �׵��� ���ϴ� ����";
		two[8] = "����ü �����ϱ�?";
		for(int i=9;i<15;i++)
			two[i] = "";
	}
	
	public void InitThree()
	{
		three[0] = "�׳��� ����� ���� ��";
		three[1] = "�� ����� ����̿�";
		three[2] = "���Ҵ�.";
		three[3] = "�ʴɷ��� ����ϴ� ��";
		three[4] = "�� �����ϰ� �׳�� ��";
		three[5] = "�ǽ������� �ʴɷ��� ��";
		three[6] = "���߾��� �װ��� ����";
		three[7] = "�ϱ����ؼ� �����ǿ� ��";
		three[8] = "�ݽ�Ű�� �°� ������";
		three[9] = "�����Ͽ���.";
		three[10] = "�׳డ ȥ�����¿� ��";
		three[11] = "������ �׵��� ������";
		three[12] = "�ߴ��ϱ� �̸�����.";
		three[13] = "";
		three[14] = "";
	}
	
	public void InitFour()
	{
		four[0] = "ȥ�����¿��� ���";
		four[1] = "�׳�� �̹� ����� ��";
		four[2] = "���� �Ǿ��־���.";
		four[3] = "�������� �˾����� �� ";
		four[4] = "���� �׳�� �ʴɷ���";
		four[5] = "������ ����ع��� ��";
		four[6] = "�̴�.";
		four[7] = "�׶����� ���ο�����";
		four[8] = "�׳ฦ ���̱�� ����";
		four[9] = "�� ���̱� ���� �㿡";
		four[10] = "�������� �׳ฦ ��";
		four[11] = "������ �Ǿ��� �׳࿡";
		four[12] = "���ؼ��� �� ���ķδ�";
		four[13] = "�ҽ��� ����.";
		four[14] = "";
	}
	
	public void InitFive()
	{
		five[0] = "10�� 23�Ͽ� ���縦 ��";
		five[1] = "�� �߰����� ���� �ƹ�";
		five[2] = "�� ¡���� �������� 12";
		five[3] = "�� �ʺ��� �׳�� ���";
		five[4] = "�� �ʴɷ��� ����ϰ� ";
		five[5] = "�־���.";
		five[6] = "�׷��� ���� ������ ��";
		five[7] = "���� �ִµ��ϳ� ����";
		five[8] = "���� ��ġä�� ���� ��";
		five[9] = "���� ���� �׳��� �ź�";
		five[10] = "�� Ȯ���ؾ� �Ѵ�.";
		for(int i=11;i<15;i++)
			five[i] = "";
	}
	
	public void InitSix()
	{
		six[0] = "������ GH���� ��п�";
		six[1] = "���ҿ��� �ʴɷ��ڵ���";
		six[2] = "�߰��ߴٴ� ������ ��";
		six[3] = "���Ͽ���.";
		six[4] = "�Ƹ��� �׵��� �ʴɷ���";
		six[5] = "�� �̿��ؼ� ���빫�⸦";
		six[6] = "������� �Ӽ��� �� �ϴ�.";
		six[7] = "�ʴɷ����� �ź�Ȯ�� ";
		six[8] = "�Ŀ� �����Ҹ� �����ı�";
		six[9] = "���Ѿ� �Ѵ�.";
		six[10] = "���� �ʴɷ����� �ź�Ȯ ";
		six[11] = "���� �Ұ����ϸ� �����";
		six[12] = "���� �������.";
		six[13] = "";
		six[14] = "";
	}
	
	public void InitSeven()
	{
		seven[0] = "�׸� �� ó�� �������� ��";
		seven[1] = "���� ������ �װ� �����";
		seven[2] = "���� ���� ������ ���̴�.";
		seven[3] = "�׷��� �״� ���� ������";
		seven[4] = "�ߵ����� ���ϰ� �����Ͽ�";
		seven[5] = "������ 4���̳� �׿���";
		seven[6] = "������ ������ 23���� ��";
		seven[7] = "�������� �װų� ���ƴ�.";
		seven[8] = "�׷����� �׵� ���纸�ٴ�";
		seven[9] = "���� ���̴�.";
		for(int i=10;i<15;i++)
			seven[i] = "";
	}
	
	public void InitEight()
	{
		eight[0] = "���� ���� ���� �� 8�ð�";
		eight[1] = "�� ������ ��ǥ�� Ȯ����";
		eight[2] = "�� ���� �ÿ� �ǹ� ��ü��";
		eight[3] = "���Ľ�Ų��.";
		for(int i=4;i<15;i++)
			eight[i] = "";
	}
	
	public void InitNine()
	{
		nine[0] = "������ �� ������ ����";
		nine[1] = "���� �� �̹� �׾�����";
		nine[2] = "�ž�.";
		nine[3] = "�˰� ���� ������ ����";
		nine[4] = "�ʴɷ��ڸ� ����� ����";
		nine[5] = "�� �Ϻη� �ΰ� ������";
		nine[6] = "�ֵ��� ���ſ���.";
		nine[7] = "�׸���� �츮 ���Ÿ�";
		nine[8] = "���ں��ϰ� ������ ��";
		nine[9] = "��.";
		nine[10] = "���� �� ����� ����";
		nine[11] = "�˸� �ž�.";
		nine[12] = "���� �׵�����";
		nine[13] = "(�ѼյǾ� ���� ���� ��";
		nine[14] = "��.)";
	}
	
	public void InitTen()
	{
		ten[0] = "12���� �ʴɷ��ڿ���";
		ten[1] = "������ ���ڴ� �ڵ��";
		ten[2] = "Mr. E�� Ī�Ѵ�.";
		ten[3] = "�Լ��� ������ ������";
		ten[4] = "�״� ���������̶��";
		ten[5] = "�͹��� ���� ������ ��";
		ten[6] = "���� �־���.";
		ten[7] = "������ �״� ������ ��";
		ten[8] = "���� ���������� ū ��";
		ten[9] = "���� ������ �־��� ��";
		ten[10] = "���� �ʴɷ��� ������";
		ten[11] = "���� �վƱͿ� ������";
		ten[12] = "�� �ϰ� �ִ�.";
		for(int i=13;i<15;i++)
			ten[i] = "";
	}
}
