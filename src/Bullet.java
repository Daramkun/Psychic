import javax.microedition.lcdui.*;

//
// 총알 클래스 - Monster, Objects 클래스에서 사용
//
public class Bullet extends Define
{
	short x; //총알 좌표
	short y;
	boolean direction = false;  //true 왼쪽  false 오른쪽
	Map map;
	PlaySound ps;
	
	MainCanvas mc;
	
	public void shotting()  //기관총 자동 발사
	{
		if(direction)
			x -= 5;
		else
			x += 5;
	}
	
	public Bullet(MainCanvas mc, boolean mondir, Map map)
	{
		this.mc = mc;
		direction = mondir;
		this.map = map;
		ps = new PlaySound(0);
		ps.start();
		ps.play("sound/gunshot.mmf", false);
	}
	
	public void draw(Graphics g)
	{
		g.setColor(255,255,0);
		g.fillRect(x - (map.x * 25) + Configs.x, 3 + (y * 25) + 10 + Configs.y, 5, 3);   //주인공 군인 조종 총알
	}
}
