import javax.microedition.lcdui.*;

//
// �� Ŭ���� - Play���� ���
//
public class Map extends Define
{
	// ���� ĵ����
	MainCanvas mc;
	
	// ��
	public int[][] map;
	// ���� ũ��
	byte width = 20;
	// ����ϱ� ������ ��ǥ
	byte x = 0;
	// Ÿ�� ����
	Image wall, glass, bg, tpx;
	public byte stage;
	
	public byte count;
//	������������������������������������������������������������������
	// �� ����
	public Map(MainCanvas mc, int stagenum)
	{
		this.mc = mc;
		
		try
		{
			wall = Image.createImage("tile/NT.png");
			glass = Image.createImage("tile/GT.png");
			bg = Image.createImage("tile/WT.png");  
			tpx = Image.createImage("tile/ST.png");
		}
		catch(Exception ex)
		{
			
		}
		
		switch(stagenum)
		{
		case -1:
			int[][] map00 = {
							 {0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0},
							 {1,0,0,0,0,0,0}
							};
			this.map = map00;
			width = 7;
		case 0:
			int[][] map0 = {
							{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
							{1,1,1,1,0,0,0,1,1,1,1,1,1,1,1},
							{1,1,1,1,0,1,0,1,1,1,1,0,2,1,1},
							{1,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
							{1,1,1,1,0,1,2,1,0,2,1,0,2,1,1}
						   };
			this.map = map0;
			width = 15;
			break;
		case 1:
			int[][] map1 = {
							{0,0,1,1,1,1,1,2,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,1,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0},
							{1,1,1,0,1,1,2,2,2,2,2,0,1,1,1,1,2,2,2,2,2,1,1,1,1},
							{1,0,0,0,1,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
							{1,1,1,1,1,0,0,0,0,0,2,0,1,1,1,1,2,2,2,2,2,1,1,1,1}
						   };
			this.map = map1;
			width = 25;
			break;
		case 2:
			int[][] map2 = {
							{1,1,1,1,1,1,1,1,2,1,2,2,2,2,1,2,2,2,2,2,2,2,2,2,2},
							{1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,2,2,2,2,2,2,2,2,2,2},
							{1,1,1,1,1,1,0,1,0,1,2,2,2,2,0,2,2,2,2,2,2,2,2,2,2},
							{1,0,0,0,0,0,0,1,0,1,2,2,2,2,0,0,0,0,0,0,0,0,0,0,1},
							{1,1,1,1,1,1,0,1,0,1,2,2,2,2,2,1,1,1,1,1,1,1,1,1,1}
						   };
			this.map = map2;
			width = 25;
			break;
		case 3:
			int[][] map3 = {
							{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
							{1,0,0,2,2,1,0,0,0,2,2,2,2,2,2,2,2,2,2,0,0,0,0,0,1},
							{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
							{1,1,1,1,1,1,0,0,0,1,1,1,1,1,0,3,2,2,2,0,0,0,0,0,1},
							{1,1,1,1,1,1,0,3,0,1,1,1,1,1,1,0,2,2,2,1,1,1,1,1,1}
						   };
			this.map = map3;
			width = 25;
			break;
		case 4:
			int[][] map4 = {
							{1,2,2,2,2,1,1,1,1,1,1,2,0,0,0,2,2,2,2,1,1,2,0,2,1},
							{1,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,1,2,2,1,1,2,0,2,1},
							{1,0,0,1,0,1,1,1,0,2,1,2,0,3,0,2,2,2,2,2,2,2,0,2,2},
							{1,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
							{1,1,1,1,1,1,1,1,2,1,1,1,0,0,2,2,2,2,2,2,2,2,2,2,2}
						   };
			this.map = map4;
			width = 25;
			break;
		case 5:
			int[][] map5 = {
							{1,2,2,2,2,2,2,2,1,1,1,1,0,0,0,0,0,0,1,0,3,0,2,2,2},
							{1,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,1,0,0,0,0,0,2,2,2},
							{1,0,2,2,2,0,2,2,0,1,0,1,0,1,0,0,0,1,0,2,2,0,3,2,2},
							{1,0,2,0,0,0,0,2,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0},
							{1,0,2,2,2,2,2,2,1,1,0,1,0,1,0,0,0,1,0,1,1,0,0,2,2}
						   };
			this.map = map5;
			width = 25;
			break;
		case 6:
			int[][] map6 = {
					{1,1,1,1,0,0,0,0,2,0,3,0,0,0,0,0,0,0,0,0,0,0,2,0,0},
					{1,1,1,1,0,1,0,0,2,0,0,0,1,0,0,0,0,0,0,0,0,0,2,2,0},
					{1,1,1,1,0,1,0,0,2,2,2,0,1,1,1,1,1,1,3,1,0,2,0,2,0},
					{1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
					{1,1,1,1,0,1,2,1,2,2,2,1,1,1,1,1,2,0,0,0,2,2,2,2,2},
				   };
			this.map = map6;
			width = 25;
			break;
		case 7:
			int[][] map7 = {
					{0,0,0,0,0,1,1,1,3,1,1,0,0,0,1,0,0,0,0,1,0,0,0,0,0},
					{1,1,1,1,0,1,0,0,0,1,0,0,2,0,0,0,1,1,0,0,1,0,0,1,0},
					{1,0,0,0,0,1,0,1,0,0,0,2,0,0,1,0,0,0,0,0,0,1,0,0,0},
					{1,0,0,1,0,0,0,1,0,1,0,2,0,1,0,1,0,0,1,0,0,0,1,0,0},
					{1,1,0,0,0,1,1,0,0,1,1,0,0,0,0,0,0,1,0,0,1,0,0,0,2},
				   };
			this.map = map7;
			width = 25;
			break;
		case 8:
			int[][] map8 = {
					{1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,3,0,0,0,0,0,2},
					{1,0,1,0,0,0,0,0,0,0,0,0,3,0,0,0,0,0,0,2,0,0,0,0,2},
					{1,0,0,0,1,0,1,0,1,0,1,0,0,0,1,0,1,0,2,2,2,2,1,0,2},
					{1,0,0,1,0,0,0,0,1,0,1,0,0,1,1,0,1,0,2,0,0,0,0,0,2},
					{1,1,1,1,1,1,1,1,0,2,0,0,1,0,1,2,0,0,2,2,2,2,1,2,2},
				   };
			this.map = map8;
			width = 25;
			break;
		case 9:
			int[][] map9 = {
					{1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{1,1,1,1,2,2,2,2,2,2,2,2,1,2,2,2,1,2,1,1,1,1,1,1,1},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
					{1,1,1,1,2,2,2,2,2,2,2,2,1,2,2,2,1,2,1,1,1,1,1,0,1},
					{1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1},
				   };
			this.map = map9;
			width = 25;
			break;
		case 10:
			int[][] map10 = {
					{2,2,2,2,2,3,0,0,2,0,1,0,1,0,1,0,0,0,1,0,1,0,0,3,0},
					{2,0,0,0,2,0,0,0,2,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,0},
					{2,0,2,2,2,0,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0},
					{2,2,2,2,2,2,2,2,2,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,2},
				   };
			this.map = map10;
			width = 25;
			break;
		case 11:
			int[][] map11 = {
							{0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
							{0,0,0,0,2,1,2,2,2,0,0,0,1,2,2,0,1,0,0,0,0,0,0,0,0},
							{2,2,2,2,0,0,0,0,0,0,1,2,1,2,2,0,1,2,2,2,2,2,2,2,2},
							{0,0,0,0,0,1,2,2,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{2,2,2,2,2,1,2,2,2,2,1,2,1,2,2,0,3,2,2,2,2,2,2,2,2}
						   };
			this.map = map11;
			width = 25;
			break;
		case 26:
			int[][] map26 = {
					 {0,0,0,0,0,0,0},
					 {0,0,0,0,0,0,0},
					 {0,0,0,0,0,0,0},
					 {0,0,0,0,0,0,0},
					 {1,0,0,0,0,0,0}
					};
			this.map = map26;
			break;
		}
		
		stage = (byte) stagenum;
	}
//	������������������������������������������������������������������
	// �� �׸���
	public void Draw(Graphics g)
	{		
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<width;j++)
			{
				Image out = new Image();
				switch(map[i][j])
				{
				case 0:
					out = bg;
					break;
				case 1:
					out = wall;
					break;
				case 2:
					out = tpx;
					break;
				case 3:
					out = glass;
					break;
				}
				g.drawImage(out, Configs.x + (j * 25) - (x * 25), Configs.y + 3 + (i * 25), MainCanvas.G_TL);
			}
		}
	}
}