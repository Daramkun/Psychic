import javax.microedition.lcdui.*;

//
// 이벤트 클래스 - Play에서 사용
//
public class Event extends Define
{
	MainCanvas mc;
	Play play;
	Hero hero;
	Npc npc;
	Boss boss;
	Map map;
	public boolean eventlive1;
	
	public boolean[] eventline;
	
	public Event(MainCanvas mc, Play play, Hero hero, Npc npc, Boss boss, Map map)
	{
		this.mc = mc;
		this.play = play;
		this.hero = hero;
		this.npc = npc;
		this.boss = boss;
		this.map = map;
		
		eventlive1 = true;
		
		switch(map.stage)
		{
		case -1:
			eventline = new boolean[5];
			break;
		case 0:
			eventline = new boolean[8];
			break;
		case 1:
			eventline = new boolean[1];
			break;
		case 2:
			eventline = new boolean[2];
			break;
		case 3:
			eventline = new boolean[6];
			break;
		case 4:
			eventline = new boolean[12];
			break;
		case 5:
			eventline = new boolean[2];
			break;
		case 6:
			eventline = new boolean[14];
			break;
		case 7:
			eventline = new boolean[3];
			break;
		case 8:
			eventline = new boolean[8];
			break;
		case 9:
			eventline = new boolean[10];
			break;
		case 10:
			eventline = new boolean[19];
			break;
		case 11:
			eventline = new boolean[8];
			break;
		case 12:
			eventline = new boolean[8];
			break;
		}
	}
	
	public void Crash(Graphics g)
	{
		switch(map.stage)
		{
		case -1:
			MOne();
			break;
		case 0:
			One();
			break;
		case 1:
			Two();
			break;
		case 2:
			Three();
			break;
		case 3:
			Four();
			break;
		case 4:
			Five();
			break;
		case 5:
			Six();
			break;
		case 6:
			Seven();
			break;
		case 7:
			Eight();
			break;
		case 8:
			Nine();
			break;
		case 9:
			Ten();
			break;
		case 10:
			Eleven();
			break;
		case 11:
			Twelve();
			break;
		case 12:
			Ending();
			break;
		}
	}
	
	void MOne()
	{
		try
		{
			if(eventlive1)
			{
				if(eventline[0] == false)
				{
					play.msgBack = Image.createImage("event/op1.png");
					play.msgName = "리사";
					play.msgContent1 = "2009년 1월 1일 올해도 새해가";
					play.msgContent2 = "밝았다.";
					
					eventline[0] = true;
				}
				else if(eventline[1] == false)
				{
					play.msgBack = Image.createImage("event/op1.png");
					play.msgName = "리사";
					play.msgContent1 = "평소와 다를 것 없는 일상.";
	
					eventline[1] = true;
				}
				else if(eventline[2] == false)
				{
					play.msgBack = Image.createImage("event/op2.png");
					play.msgName = "리사";
					play.msgContent1 = "하지만...";
	
					eventline[2] = true;
				}
				else if(eventline[3] == false)
				{
					play.msgBack = Image.createImage("event/op2.png");
					play.msgName = "리사";
					play.msgContent1 = "그 일상은 조금씩";
	
					eventline[3] = true;
				}
				else if(eventline[4] == false)
				{
					play.msgBack = Image.createImage("event/op3.png");
					play.msgName = "리사";
					play.msgContent1 = "일그러져 나에게로 다가왔다.";
	
					eventline[4] = true;
					play.ChangeStage(0);
				}
			}
		}
		catch(Exception e)
		{}
	}

	void One()
	{
		if(eventlive1)
		{
			if(eventline[0] == false)
			{
				npc.x = 2;
				npc.y = 3;
				npc.live = true;
				npc.direction = true;
				play.msgName = "리사";
				play.msgContent1 = "여기는 도데체...";
				eventline[0] = true;
			}
			else if(eventline[1] == false)
			{
				play.msgName = "???";
				play.msgContent1 = "드디어 깨어나셨군요.";
				play.msgContent2 = "당신을 기다렸습니다.";
				eventline[1] = true;
			}
			else if(eventline[2] == false)
			{
				play.msgName = "리사";
				play.msgContent1 = "당신은 누구시죠?";
				eventline[2] = true;
			}
			else if(eventline[3] == false)
			{
				play.msgName = "???";
				play.msgContent1 = "차차 알아가게 될 겁니다.";
				play.msgContent2 = "그러면 저는 이만...";
				eventline[3] = true;
			}
			else if(eventline[4] == false)
			{
				npc.x++;
				eventline[4] = true;
			}
			else if(eventline[5] == false)
			{
				play.msgName = "???";
				play.msgContent1 = "아! 예전과는 다른 뭔가";
				play.msgContent2 = "가 느껴지지 않습니까?";
				eventline[5] = true;
			}
			else if(eventline[6] == false)
			{
				npc.live = false;
				eventline[6] = true;
			}
			else if(eventline[7] == false)
			{
				play.msgName = "리사";
				play.msgContent1 = "저 자식 아무래도 밖으로";
				play.msgContent2 = "나가야 될 거 같은데...";
				eventline[7] = true;
				eventlive1 = false;
			}
		}	
	}

	void Two()
	{
		if(eventlive1)
		{
			if(eventline[0] == false)
			{
				play.msgName = "리사";
				play.msgContent1 = "도대체 내 몸이 어떻게";
				play.msgContent2 = "되어버린 거야?";
				eventline[0] = true;
				eventlive1 = false;
			}
		}
	}
	
	void Three()
	{
		if(eventlive1)
		{
			if(eventline[0] == false)
			{
				play.msgName = "리사";
				play.msgContent1 = "도대체 여기서는 무슨";
				play.msgContent2 = "일이 벌어지고 있는 거지?";
				eventline[0] = true;
			}
			else if(eventline[1] == false)
			{
				play.msgName = "리사";
				play.msgContent1 = "아무래도 여긴 평범한 연";
				play.msgContent2 = "구소가 아닌 것 같아.";
				eventline[1] = true;		
				eventlive1 = false;
			}
		}
	}
	
	void Four()
	{
		if(eventlive1)
		{
			if(eventline[0] == false)
			{
				npc.x = 4;
				npc.y = 2;
				npc.live = true;
				npc.direction = true;
				play.msgName = "리사";
				play.msgContent1 = "당신은?";
				eventline[0] = true;
			}
			else if(eventline[1] == false)
			{
				play.msgName = "??";
				play.msgContent1 = "이제 슬슬 힘에 눈을 뜨";
				play.msgContent2 = "셨겠죠? 하지만 저희는";
				eventline[1] = true;
			}
			else if(eventline[2] == false)
			{
				play.msgName = "???";
				play.msgContent1 = "아직 더 알고 싶은것이";
				play.msgContent2 = "많습니다. 좀 더 고생을";
				eventline[2] = true;
			}
			else if(eventline[3] == false)
			{
				play.msgName = "???";
				play.msgContent1 = "해주셔야 할 것 같군요.";
				play.msgContent2 = "아! 제 앞에서는 당신의";
				eventline[3] = true;					
			}
			else if(eventline[4] == false)
			{
				play.msgName = "???";
				play.msgContent1 = "힘이 통하진 않을겁니다.";
				play.msgContent2 = "그 점 참고해두시길...";
				eventline[4] = true;
			}
			else if(eventline[5] == false)
			{
				play.msgName = "리사";
				play.msgContent1 = "...";
				npc.live = false;
				eventline[5] = true;
				eventlive1 = false;
			}
		}
	}
	
	void Five()
	{
		if(eventlive1)
		{
			if(eventline[0] == false)
			{
				boss.x = 4;
				boss.y = 3;
				boss.live = true;
				boss.direction = true;
				play.msgName = "리사";
				play.msgContent1 = "어? 아직도 여기 민간인이...";
				eventline[0] = true;
			}
			else if(eventline[1] == false)
			{
				play.msgName = "???";
				play.msgContent1 = "으윽...";
				eventline[1] = true;
			}
			else if(eventline[2] == false)
			{
				play.msgName = "리사";
				play.msgContent1 = "저기....";
				play.msgContent2 = "당신은 누구죠?";
				eventline[2] = true;
			}
			else if(eventline[3] == false)
			{
				play.msgName = "스티브";
				play.msgContent1 = "저는 스티브라고 합니다.";
				play.msgContent2 = "혹시 당신도 여기 감금당했나요?";
				eventline[3] = true;					
			}
			else if(eventline[4] == false)
			{
				play.msgName = "리사";
				play.msgContent1 = "아마도 그런거 같은데요...";
				eventline[4] = true;
			}
			else if(eventline[5] == false)
			{
				play.msgName = "스티브";
				play.msgContent1 = "역시... 그때 돈을 갚았어야";
				play.msgContent2 = "했는데!";
				eventline[5] = true;
			}
			else if(eventline[6] == false)
			{
				play.msgName = "리사";
				play.msgContent1 = "저기요 혹시 여기서 무슨일이";
				play.msgContent2 = "있었는지 알고 계세요?";
				eventline[6] = true;
			}
			else if(eventline[7] == false)
			{
				play.msgName = "스티브";
				play.msgContent1 = "아뇨 저는 그때 기절해버려서";
				play.msgContent2 = "아무것도 모르...콜록 콜록";
				eventline[7] = true;
			}
			else if(eventline[8] == false)
			{
				play.msgName = "리사";
				play.msgContent1 = "피가 나네요! 어서 응급처";
				play.msgContent2 = "치를...";
				eventline[8] = true;
			}
			else if(eventline[9] == false)
			{
				play.msgName = "스티브";
				play.msgContent1 = "아뇨 괜찮습니다. 가까운 곳에";
				play.msgContent2 = "의무실이 있던거 같은데...";
				eventline[9] = true;
			}
			else if(eventline[10] == false)
			{
				play.msgName = "스티브";
				play.msgContent1 = "그럼 전 이만...";
				eventline[10] = true;
			}
			else if(eventline[11] == false)
			{
				play.msgName = "리사";
				play.msgContent1 = "도대체... 이런 곳 어디에";
				play.msgContent2 = "의무실이 있다는 건지....";
				boss.live = false;
				eventline[11] = true;
				eventlive1 = false;
			}
		}
	}
	
	void Six()
	{
		if(eventlive1)
		{
			if(eventline[0] == false)
			{
				play.msgName = "리사";
				play.msgContent1 = "젠장 역시 그 녀석을 잡아";
				play.msgContent2 = "뒀어야했어! 다음에 만나면";
				eventline[0] = true;
				}
			else if(eventline[1] == false)
			{
				play.msgName = "리사";
				play.msgContent1 = "반드시 잡아주마!";
				eventline[1] = true;
				eventlive1 = false;
			}
		}
	}
	
	void Seven()
	{
		if(eventlive1)
		{
			if(eventline[0] == false)
			{
				npc.x = 3;
				npc.y = 3;
				npc.direction = true;
				npc.live = true;
				play.msgName = "리사";
				play.msgContent1 = "다시 만나는군.";
				eventline[0] = true;
			}
			else if(eventline[1] == false)
			{
				play.msgName = "???";
				play.msgContent1 = "오랜만입니다. 그동안 건강히";
				play.msgContent2 = "지냈는지? 뭐 아직 장난이 덜";
				eventline[1] = true;
			}
			else if(eventline[2] == false)
			{
				play.msgName = "???";
				play.msgContent1 = "하군요.";
				eventline[2] = true;
			}
			else if(eventline[3] == false)
			{
				play.msgName = "리사";
				play.msgContent1 = "(역시 멋대로 지껄이는군)";
				eventline[3] = true;
			}
			else if(eventline[4] == false)
			{
				play.msgName = "???";
				play.msgContent1 = "아직 당신의 동료를 만나보지";
				play.msgContent2 = "못했습니까? 이 건물에 한 명";
				eventline[4] = true;
			}
			else if(eventline[5] == false)
			{
				play.msgName = "???";
				play.msgContent1 = "더 있는 걸로 알고 있습니다만.";
				eventline[5] = true;
			}
			else if(eventline[6] == false)
			{
				play.msgName = "리사";
				play.msgContent1 = "?!";
				eventline[6] = true;
			}
			else if(eventline[7] == false)
			{
				play.msgName = "???";
				play.msgContent1 = "여기에 있는 사람들을 죽인";
				play.msgContent2 = "건 그라고 알고 있는 데요?";
				eventline[7] = true;
			}
			else if(eventline[8] == false)
			{
				play.msgName = "리사";
				play.msgContent1 = "도대체 무슨 말을 하려는";
				play.msgContent2 = "거죠?";
				eventline[8] = true;
			}
			else if(eventline[9] == false)
			{
				play.msgName = "???";
				play.msgContent1 = "아마 그는 이곳을 나가면";
				play.msgContent2 = "모든 사람들을 죽이려 할테죠.";
				eventline[9] = true;
			}
			else if(eventline[10] == false)
			{
				play.msgName = "???";
				play.msgContent1 = "아마도요. 그것을 막을 수 있";
				play.msgContent2 = "는 사람은 당신 밖에 없는 듯";
				eventline[10] = true;
			}
			else if(eventline[11] == false)
			{
				play.msgName = "???";
				play.msgContent1 = "싶습니다.";
				eventline[11] = true;
			}
			else if(eventline[12] == false)
			{
				play.msgName = "리사";
				play.msgContent1 = "기다려! 뭐야 저녀석 자기 할";
				play.msgContent2 = "말만 하고 가버리고...";
				npc.live = false;
				eventline[12] = true;
			}
			else if(eventline[13] == false)
			{
				play.msgName = "리사";
				play.msgContent1 = "혹시 그 녀석이 스티브?";
				eventline[13] = true;
				eventlive1 = false;
			}
		}
	}
	
	void Eight()
	{
		if(eventlive1)
		{
			if(eventline[0] == false)
			{
				play.msgName = "리사";
				play.msgContent1 = "여기 있는 것들 모두 스";
				play.msgContent2 = "티브의 짓이겠지? 일단";
				eventline[0] = true;
			}
			else if(eventline[1] == false)
			{
				play.msgName = "리사";
				play.msgContent1 = "그 검은 양복 녀석 말은";
				play.msgContent2 = "맞는 것 같긴 한데...";
				eventline[1] = true;
			}
			else if(eventline[2] == false)
			{
				play.msgName = "리사";
				play.msgContent1 = "아무래도 스티브를 막아야";
				play.msgContent2 = "겠어.";
				eventline[2] = true;
				eventlive1 = false;
			}
		}
	}
	
	void Nine()
	{
		if(eventlive1)
		{
			if(eventline[0] == false)
			{
				boss.x = 2;
				boss.y = 3;
				boss.direction = true;
				boss.live = true;
				play.msgName = "리사";
				play.msgContent1 = "드디어 만났군.";
				eventline[0] = true;
			}
			else if(eventline[1] == false)
			{
				play.msgName = "스티브";
				play.msgContent1 = "...";
				eventline[1] = true;
			}
			else if(eventline[2] == false)
			{
				play.msgName = "리사";
				play.msgContent1 = "그건 그렇고 너의 목적이";
				play.msgContent2 = "뭐야?";
				eventline[2] = true;
			}
			else if(eventline[3] == false)
			{
				play.msgName = "스티브";
				play.msgContent1 = "아직 생각한 것은 없어.";
				play.msgContent2 = "그저...";
				eventline[3] = true;
			}
			else if(eventline[4] == false)
			{
				play.msgName = "리사";
				play.msgContent1 = "그저?";
				eventline[4] = true;
			}
			else if(eventline[5] == false)
			{
				play.msgName = "스티브";
				play.msgContent1 = "이곳에서 벗어나고 싶을";
				play.msgContent2 = "뿐이야.";
				eventline[5] = true;
			}
			else if(eventline[6] == false)
			{
				boss.live = false;
				play.msgName = "리사";
				play.msgContent1 = "또 사라져버렸군. 역시";
				play.msgContent2 = "나와 같은 능력을 사용";
				eventline[6] = true;
			}
			else if(eventline[7] == false)
			{
				play.msgName = "리사";
				play.msgContent1 = "하는 건가?";
				eventline[7] = true;
				eventlive1 = false;
			}
		}
	}
	
	void Ten()
	{
		if(eventlive1)
		{
			if(eventline[0] == false)
			{
				npc.x = 3;
				npc.y = 2;
				npc.direction = true;
				npc.live = true;
				play.msgName = "???";
				play.msgContent1 = "15분 쯤 늦었군요.";
				eventline[0] = true;
			}
			else if(eventline[1] == false)
			{
				play.msgName = "리사";
				play.msgContent1 = "검은 양복! 여기는 대체 뭐";
				play.msgContent2 = "하는 곳이지? 단순한 연구실";
				eventline[1] = true;
			}
			else if(eventline[2] == false)
			{
				play.msgName = "리사";
				play.msgContent1 = "로는 보이지 않는데?";
				eventline[2] = true;
			}
			else if(eventline[3] == false)
			{
				play.msgName = "???";
				play.msgContent1 = "글쎄요... 제가 만들었지만";
				play.msgContent2 = "저도 이곳이 도대체 뭐하는";
				eventline[3] = true;
			}
			else if(eventline[4] == false)
			{
				play.msgName = "???";
				play.msgContent1 = "곳인지 모르겠습니다. 역시";
				play.msgContent2 = "방해꾼의 역할이 큰 것 같군";
				eventline[4] = true;
			}
			else if(eventline[5] == false)
			{
				play.msgName = "???";
				play.msgContent1 = "요. 물론 덕분에 좋은 구경";
				play.msgContent2 = "도 합니다만. 이런, 저는";
				eventline[5] = true;
			}
			else if(eventline[6] == false)
			{
				play.msgName = "???";
				play.msgContent1 = "아무래도 당신을 앞질러간";
				play.msgContent2 = "사람을 만나야 되겠군요.";
				eventline[6] = true;
			}
			else if(eventline[7] == false)
			{
				play.msgName = "???";
				play.msgContent1 = "그럼 이만...";
				eventline[7] = true;
			}
			else if(eventline[8] == false)
			{
				npc.live = false;
				play.msgName = "리사";
				play.msgContent1 = "도대체 아는게 뭔지...";
				play.msgContent2 = "15분 쯤 늦었다고?";
				eventline[8] = true;
			}
			else if(eventline[9] == false)
			{
				npc.live = false;
				play.msgName = "리사";
				play.msgContent1 = "혹시 스티브가 여길 15분";
				play.msgContent2 = "전에 지나쳤다는 얘긴가?";
				eventline[9] = true;
				eventlive1 = false;
			}
		}
	}
	
	void Eleven()
	{
		if(eventlive1)
		{
			if(eventline[0] == false)
			{
				boss.x = 3;
				boss.y = 3;
				boss.direction = true;
				boss.live = true;
				play.msgName = "리사";
				play.msgContent1 = "여기있었군, 스티브.";
				eventline[0] = true;
			}
			else if(eventline[1] == false)
			{
				play.msgName = "스티브";
				play.msgContent1 = "아까부터 날 쫓아온 이유가";
				play.msgContent2 = "뭐야?";
				eventline[1] = true;
			}
			else if(eventline[2] == false)
			{
				play.msgName = "리사";
				play.msgContent1 = "너에 관한 것과 나에 관한 것.";
				eventline[2] = true;
			}
			else if(eventline[3] == false)
			{
				play.msgName = "스티브";
				play.msgContent1 = "글쎄, 나도 자세히는 몰라.";
				play.msgContent2 = "아직 조사중이고.";
				eventline[3] = true;
			}
			else if(eventline[4] == false)
			{
				play.msgName = "리사";
				play.msgContent1 = "무슨...?";
				eventline[4] = true;
			}
			else if(eventline[5] == false)
			{
				play.msgName = "스티브";
				play.msgContent1 = "이렇게 된 김에 나와 같이";
				play.msgContent2 = "이곳을 나가자. 나는 이런";
				eventline[5] = true;
			}
			else if(eventline[6] == false)
			{
				play.msgName = "스티브";
				play.msgContent1 = "곳에서 썩을 순 없다고.";
				eventline[6] = true;
			}
			else if(eventline[7] == false)
			{
				play.msgName = "리사";
				play.msgContent1 = "거기까지.";
				eventline[7] = true;
			}
			else if(eventline[8] == false)
			{
				play.msgName = "스티브";
				play.msgContent1 = "협상 결렬인군...";
				eventline[8] = true;
			}
			else if(eventline[9] == false)
			{
				play.msgName = "스티브";
				play.msgContent1 = "나는 여기서 나가야 해.";
				play.msgContent2 = "나가서 꼭 해야할 일이 있";
				eventline[9] = true;
			}
			else if(eventline[10] == false)
			{
				play.msgName = "스티브";
				play.msgContent1 = "다고.";
				eventline[10] = true;
			}
			else if(eventline[11] == false)
			{
				play.msgName = "리사";
				play.msgContent1 = "그 일이라는게 사람들을 죽";
				play.msgContent2 = "이는 거야? 아무리 우리를";
				eventline[11] = true;
			}
			else if(eventline[12] == false)
			{
				play.msgName = "리사";
				play.msgContent1 = "연구에 이용했다지만 그렇";
				play.msgContent2 = "다고 무고한 사람들까지";
				eventline[12] = true;
			}
			else if(eventline[13] == false)
			{
				play.msgName = "리사";
				play.msgContent1 = "죽일 필요까진 없잖아?";
				eventline[13] = true;
			}
			else if(eventline[14] == false)
			{
				play.msgName = "스티브";
				play.msgContent1 = "무고하다니...";
				eventline[14] = true;
			}
			else if(eventline[15] == false)
			{
				play.msgName = "스티브";
				play.msgContent1 = "그런가...";
				play.msgContent2 = "그놈인가?";
				eventline[15] = true;
			}
			else if(eventline[16] == false)
			{
				play.msgName = "스티브";
				play.msgContent1 = "충고하나 하지.";
				eventline[16] = true;
			}
			else if(eventline[17] == false)
			{
				play.msgName = "스티브";
				play.msgContent1 = "Mr.E,";
				play.msgContent2 = "그녀석은 믿지마.";
				boss.live = false;
				eventline[17] = true;
			}
			else if(eventline[18] == false)
			{
				play.msgName = "리사";
				play.msgContent1 = "Mr.E? 검은 양복을 말하";
				play.msgContent2 = "는 건가?";
				eventline[18] = true;
				eventlive1 = false;
			}
		}
	}
	
	void Twelve()
	{
		if(eventlive1)
		{
			if(eventline[0] == false)
			{
				npc.x = 3;
				npc.y = 3;
				npc.live = true;
				play.msgName = "???";
				play.msgContent1 = "드디어 오셨군요.";
				eventline[0] = true;
			}
			else if(eventline[1] == false)
			{
				play.msgName = "리사";
				play.msgContent1 = "Mr.E...";
				eventline[1] = true;
			}
			else if(eventline[2] == false)
			{
				play.msgName = "Mr.E";
				play.msgContent1 = "예, 제가 Mr.E입니다.";
				play.msgContent2 = "스티브에게서 저에 대해서";
				eventline[2] = true;
			}
			else if(eventline[3] == false)
			{
				play.msgName = "Mr.E";
				play.msgContent1 = "들었죠?";
				eventline[3] = true;
			}
			else if(eventline[4] == false)
			{
				play.msgName = "리사";
				play.msgContent1 = "전혀...";
				eventline[4] = true;
			}
			else if(eventline[5] == false)
			{
				play.msgName = "Mr.E";
				play.msgContent1 = "스티브가 아직도 살아있다";
				play.msgContent2 = "니 정말 아쉽군요. 빨리 처";
				eventline[5] = true;
			}
			else if(eventline[6] == false)
			{
				play.msgName = "Mr.E";
				play.msgContent1 = "치하시기 바랍니다. 그는";
				play.msgContent2 = "제정신이 아니니까요.";
				eventline[6] = true;
			}
			else if(eventline[7] == false)
			{
				npc.live = false;
				play.msgName = "리사";
				play.msgContent1 = "뻔한 속임수에 내가 넘어";
				play.msgContent2 = "갈거라 생각하면 오산이지.";
				eventline[7] = true;
				eventlive1 = false;
			}
		}
	}
	
	void Ending()
	{
		if(eventlive1)
		{
			try
			{
				if(eventline[0] == false)
				{
					boss.x = 6;
					boss.y = 3;
					boss.live = true;
					boss.direction = false;
					
					eventline[0] = true;
					
					play.msgName = "리사";
					play.msgContent1 = "혹시 스티브?";
				}
				else if(eventline[1] == false)
				{
					hero.x++;
					boss.live = false;
					Thread.sleep(150);
					eventline[1] = true;
				}
				else if(eventline[2] == false)
				{
					hero.x++;
					Thread.sleep(150);
					eventline[2] = true;
				}
				else if(eventline[2] == false)
				{
					Thread.sleep(150);
					eventline[2] = true;
				}
				else if(eventline[4] == false)
				{
					play.msgBack = Image.createImage("event/ed1.png");
					play.msgName = "리사";
					play.msgContent1 = "뒤를 조심하라고?";
					
					eventline[4] = true;
				}
				else if(eventline[5] == false)
				{
					play.msgBack = Image.createImage("event/ed2.png");
					play.msgName = "리사";
					play.msgContent1 = "꺄악!";
					
					eventline[5] = true;
				}
				else if(eventline[6] == false)
				{
					play.msgBack = Image.createImage("event/ed3.png");
					play.msgName = "리사";
					play.msgContent1 = "...";
					eventline[6] = true;
				}
				else if(eventline[7] == false)
				{
					eventline[7] = true;
					eventlive1 = false;
					mc.GameState = MENU;
				}
			}
			catch(Exception ex)
			{}
		}
	}
}
