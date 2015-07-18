import javax.microedition.lcdui.*;

//
// 주인공 클래스 - Play에서 사용
//
public class Hero extends Define
{	
	MainCanvas mc;
	// 주인공 오른쪽 이미지
	Image img1[];
	// 주인공 왼쪽 이미지
	Image img2[];
	// 주인공 반투명 오른쪽 이미지
	Image aimg1[];
	// 주인공 반투명 왼쪽 이미지
	Image aimg2[];
	Image dead;
	// 주인공의 좌표(타일 기준)
	byte x = 1;
	byte y = 3;
	// 주인공이 바라보는 방향(false가 오른쪽, true가 왼쪽)
	boolean direction;
	// 주인공이 움직이는 프레임
	byte frame;
	// 프레임이 뒤로 돌아가는 경우
	boolean backframe;
	// 주인공 체력 및 마력
	public byte hp = 10, sp = 50;
	// 주인공 움직임 카운트
	byte count = 0;
	// 활성화된 스킬 번호
	public byte sk = 1;
	// 스킬 사용중인지 체크
	public boolean skenable;
	
	PlaySound ps;
	
	Map map;
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// 히어로 클래스 생성
	public Hero(MainCanvas mc, Map map, int x, int y)
	{
		this.mc = mc;
		
		img1 = new Image[5];
		img2 = new Image[5];
		aimg1 = new Image[5];
		aimg2 = new Image[5];
		
		this.x = (byte) x;
		this.y = (byte) y;
		
		try
		{
			for(int i = 0;i<5;i++)
			{
				img1[i] = Image.createImage("hero/hero" + i + ".png");
			}
			
			for(int i = 0;i<5;i++)
			{
				img2[i] = Image.createImage("hero/hero" + i + "a.png");
			}
			
			for(int i = 0;i<5;i++)
			{
				aimg1[i] = Image.createImage("hero/visible/herov" + i + ".png");
			}
			
			for(int i = 0;i<5;i++)
			{
				aimg2[i] = Image.createImage("hero/visible/herov" + i + "a.png");
			}
			
			dead = Image.createImage("hero/herod.png");
		}
		catch(Exception ex)
		{

		}
		frame = 0;
		direction = false;
		
		this.map = map;
		
		skenable = false;
		
		ps = new PlaySound(0);
		ps.start();
	}
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// 히어로를 그림
	public void Draw(Graphics g)
	{
		try
		{
			if(hp != 0)
			{
				if(y == 4)
				{
					hp = 0;
				}
			}
			
			if(hp > 0)
				if(!direction)
					if(sk == 2 && skenable)
						g.drawImage(aimg1[frame], Configs.x + (x * 25) + 5, 3 + Configs.y + (y * 25), MainCanvas.G_TL);
					else
						g.drawImage(img1[frame], Configs.x + (x * 25) + 5, 3 + Configs.y + (y * 25), MainCanvas.G_TL);
				else
					if(sk == 2 && skenable)
						g.drawImage(aimg2[frame], Configs.x + (x * 25) + 5, 3 + Configs.y + (y * 25), MainCanvas.G_TL);
					else
						g.drawImage(img2[frame], Configs.x + (x * 25) + 5, 3 + Configs.y + (y * 25), MainCanvas.G_TL);
			else
				g.drawImage(dead, Configs.x + x * 25, 18 + Configs.y + (y * 25), MainCanvas.G_TL);
			
			if(mc.nKey == 0)
				frame = 0;
			else
				if(!backframe)
					if(frame < 4)
						frame++;
					else
						backframe = true;
				else
					if(frame > 1)
						frame--;
					else
						backframe = false;
			
			if(y != 4)
			{
				if(!Lib.Crashcheck(x + map.x, y + 1, map))
				{
					y++;
				}
			}
			
			count++;
		}
		catch(Exception ex) {}
	}
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// 키 눌렀을 때
	public void Key()
	{
		if(hp > 0)
		{
			switch(mc.nKey)
			{
			case KEY_STAR:
				sk = 1;
				skenable = false;
				mc.nKey = 0;
				break;
			case KEY_NUM0:
				sk = 2;
				skenable = false;
				mc.nKey = 0;
				break;
			case KEY_POUND:
				sk = 3;
				skenable = false;
				mc.nKey = 0;
				break;
			}
			
			if(skenable && (sk == 3 || sk == 1)) return;
			
			switch(mc.nKey)
			{
			case KEY_LEFT:
			case KEY_NUM4:
				if(!direction)
				{
					direction = true;
					break;
				}
				if(!Lib.Crashcheck(x + map.x - 1, y, map))
				{
					if(count >= 4)
					{
						if(x != 3 && map.x > 0)
							x--;
						else if(map.x == 0)
							x--;
						else
							map.x--;
						count = 0;
					}
				}
					
				break;
			case KEY_RIGHT:
			case KEY_NUM6:
				if(direction)
				{
					direction = false;
					break;
				}
				if(!Lib.Crashcheck(x + map.x + 1, y, map))
				{
					if(count >= 4)
					{
						if(x != 3 && map.x < map.width - 7)
							x++;
						else if(map.x == map.width - 7)
							x++;
						else
							map.x++;
						count = 0;
					}
				}
				break;
			case KEY_DOWN:
			case KEY_NUM8:
					
				break;
			case KEY_UP:
			case KEY_NUM2:
					
				break;
			case KEY_NUM5:
			case KEY_FIRE:
				if(mc.KeyPress == 1)
				{
					if(count >= 2)
					{
						switch(sk)
						{
						case 2:
							if(!skenable)
							{
								if(sp >= 5)
								{
									sp -= 5;
									skenable = true;
									ps.play("sound/invisible.mmf", false);
									break;
								}
							}
							else
							{
								skenable = false;
								break;
							}
							break;
						}
						count = 0;
					}
					break;
				}
			}
		}
	}
}
