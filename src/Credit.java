import javax.microedition.lcdui.*;

//
// 제작자 정보 클래스 - Menu에서 사용
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
		g.drawString("<기획>김승민", Configs.x + 74, Configs.y + 51, MainCanvas.G_TL);
		g.drawString("<그래픽>윤성진", Configs.x + 74, Configs.y + 71, MainCanvas.G_TL);
		g.drawString("<프로그래밍>", Configs.x + 74, Configs.y + 91, MainCanvas.G_TL);
		g.drawString("진재연", Configs.x + 80, Configs.y + 111, MainCanvas.G_TL);
		g.drawString("김여원", Configs.x + 80, Configs.y + 131, MainCanvas.G_TL);
	}
}
