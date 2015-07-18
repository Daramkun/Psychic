import javax.microedition.lcdui.*;

//
// �Ѿ� Ŭ���� - Monster, Objects Ŭ�������� ���
//
public class Bullet extends Define
{
	short x; //�Ѿ� ��ǥ
	short y;
	boolean direction = false;  //true ����  false ������
	Map map;
	PlaySound ps;
	
	MainCanvas mc;
	
	public void shotting()  //����� �ڵ� �߻�
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
		g.fillRect(x - (map.x * 25) + Configs.x, 3 + (y * 25) + 10 + Configs.y, 5, 3);   //���ΰ� ���� ���� �Ѿ�
	}
}
