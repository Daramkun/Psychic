import javax.microedition.lcdui.*;

//
// ������ ���� Ŭ���� - Menu���� ���
//
public class Credit extends Define
{
	MainCanvas mc;
	
	public Credit(MainCanvas mc)
	{
		this.mc = mc;
	}
	
	public void Draw(Graphics g)
	{
		g.setColor(0x000000);
		g.fillRect(Configs.x + 60, Configs.y + 50, 116, 92);
		g.setColor(240,240,240);
		g.drawString("Team ReplingCube", Configs.x + 71, Configs.y + 31, MainCanvas.G_TL);
		g.drawString("<��ȹ>��¹�", Configs.x + 74, Configs.y + 51, MainCanvas.G_TL);
		g.drawString("<�׷���>������", Configs.x + 74, Configs.y + 71, MainCanvas.G_TL);
		g.drawString("<���α׷���>", Configs.x + 74, Configs.y + 91, MainCanvas.G_TL);
		g.drawString("���翬", Configs.x + 80, Configs.y + 111, MainCanvas.G_TL);
		g.drawString("�迩��", Configs.x + 80, Configs.y + 131, MainCanvas.G_TL);
	}
}
