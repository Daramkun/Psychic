import javax.microedition.lcdui.*;

//
// 다큐먼트 클래스 - Gmenu에서 사용
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
	final String NON_DOC = "얻지 못한 문서";
	
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
				tp = "리사 연구 보고서-01";
			else
				tp = NON_DOC;
			g.drawImage(cur, Configs.x + 40, Configs.y + 22, MainCanvas.G_TL);
			break;
		case 2:
			if(Configs.pages[1])
				tp = "의문의 보고서";
			else
				tp = NON_DOC;
			g.drawImage(cur, Configs.x + 68, Configs.y + 22, MainCanvas.G_TL);
			break;
		case 3:
			if(Configs.pages[2])
				tp = "리사 연구 보고서-02";
			else
				tp = NON_DOC;
			g.drawImage(cur, Configs.x + 96, Configs.y + 22, MainCanvas.G_TL);
			break;
		case 4:
			if(Configs.pages[3])
				tp = "리사 연구 보고서-03";
			else
				tp = NON_DOC;
			g.drawImage(cur, Configs.x + 120, Configs.y + 22, MainCanvas.G_TL);
			break;
		case 5:
			if(Configs.pages[4])
				tp = "회의록";
			else
				tp = NON_DOC;
			g.drawImage(cur, Configs.x + 144, Configs.y + 22, MainCanvas.G_TL);
			break;
		case 6:
			if(Configs.pages[5])
				tp = "작전설명쪽지";
			else
				tp = NON_DOC;
			g.drawImage(cur, Configs.x + 40, Configs.y + 46, MainCanvas.G_TL);
			break;
		case 7:
			if(Configs.pages[6])
				tp = "스티브 연구 보고서";
			else
				tp = NON_DOC;
			g.drawImage(cur, Configs.x + 68, Configs.y + 46, MainCanvas.G_TL);
			break;
		case 8:
			if(Configs.pages[7])
				tp = "작전지침서";
			else
				tp = NON_DOC;
			g.drawImage(cur, Configs.x + 96, Configs.y + 46, MainCanvas.G_TL);
			break;
		case 9:
			if(Configs.pages[8])
				tp = "리사에게";
			else
				tp = NON_DOC;
			g.drawImage(cur, Configs.x + 120, Configs.y + 46, MainCanvas.G_TL);
			break;
		case 10:
			if(Configs.pages[9])
				tp = "코드명 Mr. E에 대해서";
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
		one[0] = "현재 우리가 리사를";
		one[1] = "감금한지 20일이 경";
		one[2] = "과했다.";
		one[3] = "현재 그녀의 초능력은";
		one[4] = "상상을 초월할 정도로";
		one[5] = "매우 강력하였다.";
		one[6] = "지금 당장은 활용하";
		one[7] = "기엔 힘들지만 그녀";
		one[8] = "에 대해서 더 정밀한 ";
		one[9] = "조사가 가능하다면";
		one[10] = "군사용으로도 활용이";
		one[11] = "가능할 것 같다.";
		one[12] = "";
		one[13] = "";
		one[14] = "";
	}
	
	public void InitTwo()
	{
		two[0] = "현재 그녀를 연구하고";
		two[1] = "있는 동안에 많은 사상";
		two[2] = "자가 발생하였다.";
		two[3] = "어제도 3명이나 죽고";
		two[4] = "이 글을 쓰는 동안에도";
		two[5] = "1명이 죽었다.";
		two[6] = "이렇게 무리하면서까";
		two[7] = "지 그들이 원하는 것은";
		two[8] = "도대체 무엇일까?";
		for(int i=9;i<15;i++)
			two[i] = "";
	}
	
	public void InitThree()
	{
		three[0] = "그녀의 어렸을 때는 정";
		three[1] = "말 평범한 어린아이와";
		three[2] = "같았다.";
		three[3] = "초능력을 사용하는 것";
		three[4] = "을 제외하고 그녀는 무";
		three[5] = "의식적으로 초능력을 사";
		three[6] = "용했었고 그것을 연구";
		three[7] = "하기위해서 연구실에 감";
		three[8] = "금시키고 온갖 실험을";
		three[9] = "강행하였다.";
		three[10] = "그녀가 혼수상태에 빠";
		three[11] = "져서야 그들은 실험을";
		three[12] = "중단하기 이르렀다.";
		three[13] = "";
		three[14] = "";
	}
	
	public void InitFour()
	{
		four[0] = "혼수상태에서 깨어난";
		four[1] = "그녀는 이미 평범한 인";
		four[2] = "간이 되어있었다.";
		four[3] = "연기일줄 알았지만 실 ";
		four[4] = "제로 그녀는 초능력을";
		four[5] = "완전히 상실해버린 것";
		four[6] = "이다.";
		four[7] = "그때서야 정부에서는";
		four[8] = "그녀를 죽이기로 했으";
		four[9] = "나 죽이기 전날 밤에";
		four[10] = "누군가가 그녀를 빼";
		four[11] = "돌리게 되었고 그녀에";
		four[12] = "대해서는 그 이후로는";
		four[13] = "소식이 없다.";
		four[14] = "";
	}
	
	public void InitFive()
	{
		five[0] = "10월 23일에 리사를 다";
		five[1] = "시 발견했을 때는 아무";
		five[2] = "런 징조가 없었으나 12";
		five[3] = "월 초부터 그녀는 어느";
		five[4] = "새 초능력을 사용하고 ";
		five[5] = "있었다.";
		five[6] = "그러나 정작 본인은 모";
		five[7] = "르고 있는듯하나 정부";
		five[8] = "에서 눈치채기 전에 우";
		five[9] = "리가 먼저 그녀의 신병";
		five[10] = "을 확보해야 한다.";
		for(int i=11;i<15;i++)
			five[i] = "";
	}
	
	public void InitSix()
	{
		six[0] = "어젯밤 GH사의 비밀연";
		six[1] = "구소에서 초능력자들을";
		six[2] = "발견했다는 정보를 입";
		six[3] = "수하였다.";
		six[4] = "아마도 그들은 초능력자";
		six[5] = "를 이용해서 군용무기를";
		six[6] = "만들려는 속셈인 듯 하다.";
		six[7] = "초능력자의 신병확보 ";
		six[8] = "후에 연구소를 완전파괴";
		six[9] = "시켜야 한다.";
		six[10] = "만약 초능력자의 신병확 ";
		six[11] = "보가 불가능하면 사살하";
		six[12] = "여도 상관없다.";
		six[13] = "";
		six[14] = "";
	}
	
	public void InitSeven()
	{
		seven[0] = "그를 맨 처음 데려왔을 때";
		seven[1] = "에는 누구도 그가 사람을";
		seven[2] = "죽일 줄은 몰랐을 것이다.";
		seven[3] = "그러나 그는 이제 실험을";
		seven[4] = "견뎌내지 못하고 폭주하여";
		seven[5] = "어제도 4명이나 죽였고";
		seven[6] = "일주일 전에는 23명의 연";
		seven[7] = "구원들이 죽거나 다쳤다.";
		seven[8] = "그렇지만 그도 리사보다는";
		seven[9] = "나은 편이다.";
		for(int i=10;i<15;i++)
			seven[i] = "";
	}
	
	public void InitEight()
	{
		eight[0] = "만약 작전 시작 후 8시간";
		eight[1] = "이 지나도 목표를 확보하";
		eight[2] = "지 못할 시에 건물 자체를";
		eight[3] = "폭파시킨다.";
		for(int i=4;i<15;i++)
			eight[i] = "";
	}
	
	public void InitNine()
	{
		nine[0] = "누나가 이 편지를 봤을";
		nine[1] = "때엔 난 이미 죽어있을";
		nine[2] = "거야.";
		nine[3] = "알고 보니 누나랑 나는";
		nine[4] = "초능력자를 만들기 위해";
		nine[5] = "서 일부러 인공 수정한";
		nine[6] = "쌍둥이 남매였어.";
		nine[7] = "그리고는 우리 남매를";
		nine[8] = "무자비하게 실험을 했";
		nine[9] = "지.";
		nine[10] = "이제 그 사실을 세상에";
		nine[11] = "알릴 거야.";
		nine[12] = "이제 그들은…";
		nine[13] = "(훼손되어 읽을 수가 없";
		nine[14] = "다.)";
	}
	
	public void InitTen()
	{
		ten[0] = "12월에 초능력자에게";
		ten[1] = "접근한 남자는 코드명";
		ten[2] = "Mr. E로 칭한다.";
		ten[3] = "입수한 정보에 따르면";
		ten[4] = "그는 세계정복이라는";
		ten[5] = "터무니 없는 망상을 가";
		ten[6] = "지고 있었다.";
		ten[7] = "하지만 그는 실제로 웬";
		ten[8] = "만한 후진국보다 큰 세";
		ten[9] = "력을 가지고 있었고 이";
		ten[10] = "제는 초능력자 마저도";
		ten[11] = "그의 손아귀에 넣으려";
		ten[12] = "고 하고 있다.";
		for(int i=13;i<15;i++)
			ten[i] = "";
	}
}
