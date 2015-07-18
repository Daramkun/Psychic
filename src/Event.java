import javax.microedition.lcdui.*;

//
// �̺�Ʈ Ŭ���� - Play���� ���
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
					play.msgName = "����";
					play.msgContent1 = "2009�� 1�� 1�� ���ص� ���ذ�";
					play.msgContent2 = "��Ҵ�.";
					
					eventline[0] = true;
				}
				else if(eventline[1] == false)
				{
					play.msgBack = Image.createImage("event/op1.png");
					play.msgName = "����";
					play.msgContent1 = "��ҿ� �ٸ� �� ���� �ϻ�.";
	
					eventline[1] = true;
				}
				else if(eventline[2] == false)
				{
					play.msgBack = Image.createImage("event/op2.png");
					play.msgName = "����";
					play.msgContent1 = "������...";
	
					eventline[2] = true;
				}
				else if(eventline[3] == false)
				{
					play.msgBack = Image.createImage("event/op2.png");
					play.msgName = "����";
					play.msgContent1 = "�� �ϻ��� ���ݾ�";
	
					eventline[3] = true;
				}
				else if(eventline[4] == false)
				{
					play.msgBack = Image.createImage("event/op3.png");
					play.msgName = "����";
					play.msgContent1 = "�ϱ׷��� �����Է� �ٰ��Դ�.";
	
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
				play.msgName = "����";
				play.msgContent1 = "����� ����ü...";
				eventline[0] = true;
			}
			else if(eventline[1] == false)
			{
				play.msgName = "???";
				play.msgContent1 = "���� ����̱���.";
				play.msgContent2 = "����� ��ٷȽ��ϴ�.";
				eventline[1] = true;
			}
			else if(eventline[2] == false)
			{
				play.msgName = "����";
				play.msgContent1 = "����� ��������?";
				eventline[2] = true;
			}
			else if(eventline[3] == false)
			{
				play.msgName = "???";
				play.msgContent1 = "���� �˾ư��� �� �̴ϴ�.";
				play.msgContent2 = "�׷��� ���� �̸�...";
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
				play.msgContent1 = "��! �������� �ٸ� ����";
				play.msgContent2 = "�� �������� �ʽ��ϱ�?";
				eventline[5] = true;
			}
			else if(eventline[6] == false)
			{
				npc.live = false;
				eventline[6] = true;
			}
			else if(eventline[7] == false)
			{
				play.msgName = "����";
				play.msgContent1 = "�� �ڽ� �ƹ����� ������";
				play.msgContent2 = "������ �� �� ������...";
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
				play.msgName = "����";
				play.msgContent1 = "����ü �� ���� ���";
				play.msgContent2 = "�Ǿ���� �ž�?";
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
				play.msgName = "����";
				play.msgContent1 = "����ü ���⼭�� ����";
				play.msgContent2 = "���� �������� �ִ� ����?";
				eventline[0] = true;
			}
			else if(eventline[1] == false)
			{
				play.msgName = "����";
				play.msgContent1 = "�ƹ����� ���� ����� ��";
				play.msgContent2 = "���Ұ� �ƴ� �� ����.";
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
				play.msgName = "����";
				play.msgContent1 = "�����?";
				eventline[0] = true;
			}
			else if(eventline[1] == false)
			{
				play.msgName = "??";
				play.msgContent1 = "���� ���� ���� ���� ��";
				play.msgContent2 = "�̰���? ������ �����";
				eventline[1] = true;
			}
			else if(eventline[2] == false)
			{
				play.msgName = "???";
				play.msgContent1 = "���� �� �˰� ��������";
				play.msgContent2 = "�����ϴ�. �� �� �����";
				eventline[2] = true;
			}
			else if(eventline[3] == false)
			{
				play.msgName = "???";
				play.msgContent1 = "���ּž� �� �� ������.";
				play.msgContent2 = "��! �� �տ����� �����";
				eventline[3] = true;					
			}
			else if(eventline[4] == false)
			{
				play.msgName = "???";
				play.msgContent1 = "���� ������ �����̴ϴ�.";
				play.msgContent2 = "�� �� �����صνñ�...";
				eventline[4] = true;
			}
			else if(eventline[5] == false)
			{
				play.msgName = "����";
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
				play.msgName = "����";
				play.msgContent1 = "��? ������ ���� �ΰ�����...";
				eventline[0] = true;
			}
			else if(eventline[1] == false)
			{
				play.msgName = "???";
				play.msgContent1 = "����...";
				eventline[1] = true;
			}
			else if(eventline[2] == false)
			{
				play.msgName = "����";
				play.msgContent1 = "����....";
				play.msgContent2 = "����� ������?";
				eventline[2] = true;
			}
			else if(eventline[3] == false)
			{
				play.msgName = "��Ƽ��";
				play.msgContent1 = "���� ��Ƽ���� �մϴ�.";
				play.msgContent2 = "Ȥ�� ��ŵ� ���� ���ݴ��߳���?";
				eventline[3] = true;					
			}
			else if(eventline[4] == false)
			{
				play.msgName = "����";
				play.msgContent1 = "�Ƹ��� �׷��� ��������...";
				eventline[4] = true;
			}
			else if(eventline[5] == false)
			{
				play.msgName = "��Ƽ��";
				play.msgContent1 = "����... �׶� ���� ���Ҿ��";
				play.msgContent2 = "�ߴµ�!";
				eventline[5] = true;
			}
			else if(eventline[6] == false)
			{
				play.msgName = "����";
				play.msgContent1 = "����� Ȥ�� ���⼭ ��������";
				play.msgContent2 = "�־����� �˰� �輼��?";
				eventline[6] = true;
			}
			else if(eventline[7] == false)
			{
				play.msgName = "��Ƽ��";
				play.msgContent1 = "�ƴ� ���� �׶� �����ع�����";
				play.msgContent2 = "�ƹ��͵� ��...�ݷ� �ݷ�";
				eventline[7] = true;
			}
			else if(eventline[8] == false)
			{
				play.msgName = "����";
				play.msgContent1 = "�ǰ� ���׿�! � ����ó";
				play.msgContent2 = "ġ��...";
				eventline[8] = true;
			}
			else if(eventline[9] == false)
			{
				play.msgName = "��Ƽ��";
				play.msgContent1 = "�ƴ� �������ϴ�. ����� ����";
				play.msgContent2 = "�ǹ����� �ִ��� ������...";
				eventline[9] = true;
			}
			else if(eventline[10] == false)
			{
				play.msgName = "��Ƽ��";
				play.msgContent1 = "�׷� �� �̸�...";
				eventline[10] = true;
			}
			else if(eventline[11] == false)
			{
				play.msgName = "����";
				play.msgContent1 = "����ü... �̷� �� ���";
				play.msgContent2 = "�ǹ����� �ִٴ� ����....";
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
				play.msgName = "����";
				play.msgContent1 = "���� ���� �� �༮�� ���";
				play.msgContent2 = "�׾���߾�! ������ ������";
				eventline[0] = true;
				}
			else if(eventline[1] == false)
			{
				play.msgName = "����";
				play.msgContent1 = "�ݵ�� ����ָ�!";
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
				play.msgName = "����";
				play.msgContent1 = "�ٽ� �����±�.";
				eventline[0] = true;
			}
			else if(eventline[1] == false)
			{
				play.msgName = "???";
				play.msgContent1 = "�������Դϴ�. �׵��� �ǰ���";
				play.msgContent2 = "���´���? �� ���� �峭�� ��";
				eventline[1] = true;
			}
			else if(eventline[2] == false)
			{
				play.msgName = "???";
				play.msgContent1 = "�ϱ���.";
				eventline[2] = true;
			}
			else if(eventline[3] == false)
			{
				play.msgName = "����";
				play.msgContent1 = "(���� �ڴ�� �����̴±�)";
				eventline[3] = true;
			}
			else if(eventline[4] == false)
			{
				play.msgName = "???";
				play.msgContent1 = "���� ����� ���Ḧ ��������";
				play.msgContent2 = "���߽��ϱ�? �� �ǹ��� �� ��";
				eventline[4] = true;
			}
			else if(eventline[5] == false)
			{
				play.msgName = "???";
				play.msgContent1 = "�� �ִ� �ɷ� �˰� �ֽ��ϴٸ�.";
				eventline[5] = true;
			}
			else if(eventline[6] == false)
			{
				play.msgName = "����";
				play.msgContent1 = "?!";
				eventline[6] = true;
			}
			else if(eventline[7] == false)
			{
				play.msgName = "???";
				play.msgContent1 = "���⿡ �ִ� ������� ����";
				play.msgContent2 = "�� �׶�� �˰� �ִ� ����?";
				eventline[7] = true;
			}
			else if(eventline[8] == false)
			{
				play.msgName = "����";
				play.msgContent1 = "����ü ���� ���� �Ϸ���";
				play.msgContent2 = "����?";
				eventline[8] = true;
			}
			else if(eventline[9] == false)
			{
				play.msgName = "???";
				play.msgContent1 = "�Ƹ� �״� �̰��� ������";
				play.msgContent2 = "��� ������� ���̷� ������.";
				eventline[9] = true;
			}
			else if(eventline[10] == false)
			{
				play.msgName = "???";
				play.msgContent1 = "�Ƹ�����. �װ��� ���� �� ��";
				play.msgContent2 = "�� ����� ��� �ۿ� ���� ��";
				eventline[10] = true;
			}
			else if(eventline[11] == false)
			{
				play.msgName = "???";
				play.msgContent1 = "�ͽ��ϴ�.";
				eventline[11] = true;
			}
			else if(eventline[12] == false)
			{
				play.msgName = "����";
				play.msgContent1 = "��ٷ�! ���� ���༮ �ڱ� ��";
				play.msgContent2 = "���� �ϰ� ��������...";
				npc.live = false;
				eventline[12] = true;
			}
			else if(eventline[13] == false)
			{
				play.msgName = "����";
				play.msgContent1 = "Ȥ�� �� �༮�� ��Ƽ��?";
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
				play.msgName = "����";
				play.msgContent1 = "���� �ִ� �͵� ��� ��";
				play.msgContent2 = "Ƽ���� ���̰���? �ϴ�";
				eventline[0] = true;
			}
			else if(eventline[1] == false)
			{
				play.msgName = "����";
				play.msgContent1 = "�� ���� �纹 �༮ ����";
				play.msgContent2 = "�´� �� ���� �ѵ�...";
				eventline[1] = true;
			}
			else if(eventline[2] == false)
			{
				play.msgName = "����";
				play.msgContent1 = "�ƹ����� ��Ƽ�긦 ���ƾ�";
				play.msgContent2 = "�ھ�.";
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
				play.msgName = "����";
				play.msgContent1 = "���� ������.";
				eventline[0] = true;
			}
			else if(eventline[1] == false)
			{
				play.msgName = "��Ƽ��";
				play.msgContent1 = "...";
				eventline[1] = true;
			}
			else if(eventline[2] == false)
			{
				play.msgName = "����";
				play.msgContent1 = "�װ� �׷��� ���� ������";
				play.msgContent2 = "����?";
				eventline[2] = true;
			}
			else if(eventline[3] == false)
			{
				play.msgName = "��Ƽ��";
				play.msgContent1 = "���� ������ ���� ����.";
				play.msgContent2 = "����...";
				eventline[3] = true;
			}
			else if(eventline[4] == false)
			{
				play.msgName = "����";
				play.msgContent1 = "����?";
				eventline[4] = true;
			}
			else if(eventline[5] == false)
			{
				play.msgName = "��Ƽ��";
				play.msgContent1 = "�̰����� ����� ����";
				play.msgContent2 = "���̾�.";
				eventline[5] = true;
			}
			else if(eventline[6] == false)
			{
				boss.live = false;
				play.msgName = "����";
				play.msgContent1 = "�� ��������ȱ�. ����";
				play.msgContent2 = "���� ���� �ɷ��� ���";
				eventline[6] = true;
			}
			else if(eventline[7] == false)
			{
				play.msgName = "����";
				play.msgContent1 = "�ϴ� �ǰ�?";
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
				play.msgContent1 = "15�� �� �ʾ�����.";
				eventline[0] = true;
			}
			else if(eventline[1] == false)
			{
				play.msgName = "����";
				play.msgContent1 = "���� �纹! ����� ��ü ��";
				play.msgContent2 = "�ϴ� ������? �ܼ��� ������";
				eventline[1] = true;
			}
			else if(eventline[2] == false)
			{
				play.msgName = "����";
				play.msgContent1 = "�δ� ������ �ʴµ�?";
				eventline[2] = true;
			}
			else if(eventline[3] == false)
			{
				play.msgName = "???";
				play.msgContent1 = "�۽��... ���� ���������";
				play.msgContent2 = "���� �̰��� ����ü ���ϴ�";
				eventline[3] = true;
			}
			else if(eventline[4] == false)
			{
				play.msgName = "???";
				play.msgContent1 = "������ �𸣰ڽ��ϴ�. ����";
				play.msgContent2 = "���ز��� ������ ū �� ����";
				eventline[4] = true;
			}
			else if(eventline[5] == false)
			{
				play.msgName = "???";
				play.msgContent1 = "��. ���� ���п� ���� ����";
				play.msgContent2 = "�� �մϴٸ�. �̷�, ����";
				eventline[5] = true;
			}
			else if(eventline[6] == false)
			{
				play.msgName = "???";
				play.msgContent1 = "�ƹ����� ����� ��������";
				play.msgContent2 = "����� ������ �ǰڱ���.";
				eventline[6] = true;
			}
			else if(eventline[7] == false)
			{
				play.msgName = "???";
				play.msgContent1 = "�׷� �̸�...";
				eventline[7] = true;
			}
			else if(eventline[8] == false)
			{
				npc.live = false;
				play.msgName = "����";
				play.msgContent1 = "����ü �ƴ°� ����...";
				play.msgContent2 = "15�� �� �ʾ��ٰ�?";
				eventline[8] = true;
			}
			else if(eventline[9] == false)
			{
				npc.live = false;
				play.msgName = "����";
				play.msgContent1 = "Ȥ�� ��Ƽ�갡 ���� 15��";
				play.msgContent2 = "���� �����ƴٴ� ��䰡?";
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
				play.msgName = "����";
				play.msgContent1 = "�����־���, ��Ƽ��.";
				eventline[0] = true;
			}
			else if(eventline[1] == false)
			{
				play.msgName = "��Ƽ��";
				play.msgContent1 = "�Ʊ���� �� �Ѿƿ� ������";
				play.msgContent2 = "����?";
				eventline[1] = true;
			}
			else if(eventline[2] == false)
			{
				play.msgName = "����";
				play.msgContent1 = "�ʿ� ���� �Ͱ� ���� ���� ��.";
				eventline[2] = true;
			}
			else if(eventline[3] == false)
			{
				play.msgName = "��Ƽ��";
				play.msgContent1 = "�۽�, ���� �ڼ����� ����.";
				play.msgContent2 = "���� �������̰�.";
				eventline[3] = true;
			}
			else if(eventline[4] == false)
			{
				play.msgName = "����";
				play.msgContent1 = "����...?";
				eventline[4] = true;
			}
			else if(eventline[5] == false)
			{
				play.msgName = "��Ƽ��";
				play.msgContent1 = "�̷��� �� �迡 ���� ����";
				play.msgContent2 = "�̰��� ������. ���� �̷�";
				eventline[5] = true;
			}
			else if(eventline[6] == false)
			{
				play.msgName = "��Ƽ��";
				play.msgContent1 = "������ ���� �� ���ٰ�.";
				eventline[6] = true;
			}
			else if(eventline[7] == false)
			{
				play.msgName = "����";
				play.msgContent1 = "�ű����.";
				eventline[7] = true;
			}
			else if(eventline[8] == false)
			{
				play.msgName = "��Ƽ��";
				play.msgContent1 = "���� ����α�...";
				eventline[8] = true;
			}
			else if(eventline[9] == false)
			{
				play.msgName = "��Ƽ��";
				play.msgContent1 = "���� ���⼭ ������ ��.";
				play.msgContent2 = "������ �� �ؾ��� ���� ��";
				eventline[9] = true;
			}
			else if(eventline[10] == false)
			{
				play.msgName = "��Ƽ��";
				play.msgContent1 = "�ٰ�.";
				eventline[10] = true;
			}
			else if(eventline[11] == false)
			{
				play.msgName = "����";
				play.msgContent1 = "�� ���̶�°� ������� ��";
				play.msgContent2 = "�̴� �ž�? �ƹ��� �츮��";
				eventline[11] = true;
			}
			else if(eventline[12] == false)
			{
				play.msgName = "����";
				play.msgContent1 = "������ �̿��ߴ����� �׷�";
				play.msgContent2 = "�ٰ� ������ ��������";
				eventline[12] = true;
			}
			else if(eventline[13] == false)
			{
				play.msgName = "����";
				play.msgContent1 = "���� �ʿ���� ���ݾ�?";
				eventline[13] = true;
			}
			else if(eventline[14] == false)
			{
				play.msgName = "��Ƽ��";
				play.msgContent1 = "�����ϴٴ�...";
				eventline[14] = true;
			}
			else if(eventline[15] == false)
			{
				play.msgName = "��Ƽ��";
				play.msgContent1 = "�׷���...";
				play.msgContent2 = "�׳��ΰ�?";
				eventline[15] = true;
			}
			else if(eventline[16] == false)
			{
				play.msgName = "��Ƽ��";
				play.msgContent1 = "����ϳ� ����.";
				eventline[16] = true;
			}
			else if(eventline[17] == false)
			{
				play.msgName = "��Ƽ��";
				play.msgContent1 = "Mr.E,";
				play.msgContent2 = "�׳༮�� ������.";
				boss.live = false;
				eventline[17] = true;
			}
			else if(eventline[18] == false)
			{
				play.msgName = "����";
				play.msgContent1 = "Mr.E? ���� �纹�� ����";
				play.msgContent2 = "�� �ǰ�?";
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
				play.msgContent1 = "���� ���̱���.";
				eventline[0] = true;
			}
			else if(eventline[1] == false)
			{
				play.msgName = "����";
				play.msgContent1 = "Mr.E...";
				eventline[1] = true;
			}
			else if(eventline[2] == false)
			{
				play.msgName = "Mr.E";
				play.msgContent1 = "��, ���� Mr.E�Դϴ�.";
				play.msgContent2 = "��Ƽ�꿡�Լ� ���� ���ؼ�";
				eventline[2] = true;
			}
			else if(eventline[3] == false)
			{
				play.msgName = "Mr.E";
				play.msgContent1 = "�����?";
				eventline[3] = true;
			}
			else if(eventline[4] == false)
			{
				play.msgName = "����";
				play.msgContent1 = "����...";
				eventline[4] = true;
			}
			else if(eventline[5] == false)
			{
				play.msgName = "Mr.E";
				play.msgContent1 = "��Ƽ�갡 ������ ����ִ�";
				play.msgContent2 = "�� ���� �ƽ�����. ���� ó";
				eventline[5] = true;
			}
			else if(eventline[6] == false)
			{
				play.msgName = "Mr.E";
				play.msgContent1 = "ġ�Ͻñ� �ٶ��ϴ�. �״�";
				play.msgContent2 = "�������� �ƴϴϱ��.";
				eventline[6] = true;
			}
			else if(eventline[7] == false)
			{
				npc.live = false;
				play.msgName = "����";
				play.msgContent1 = "���� ���Ӽ��� ���� �Ѿ�";
				play.msgContent2 = "���Ŷ� �����ϸ� ��������.";
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
					
					play.msgName = "����";
					play.msgContent1 = "Ȥ�� ��Ƽ��?";
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
					play.msgName = "����";
					play.msgContent1 = "�ڸ� �����϶��?";
					
					eventline[4] = true;
				}
				else if(eventline[5] == false)
				{
					play.msgBack = Image.createImage("event/ed2.png");
					play.msgName = "����";
					play.msgContent1 = "����!";
					
					eventline[5] = true;
				}
				else if(eventline[6] == false)
				{
					play.msgBack = Image.createImage("event/ed3.png");
					play.msgName = "����";
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
