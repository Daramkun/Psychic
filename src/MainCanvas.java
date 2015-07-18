import javax.microedition.lcdui.*;

//
// ���� ĵ���� - ���� ó�� �����ϴ� ĵ����
//
public class MainCanvas extends Define implements Runnable
{
//	======================================================================================
	// �̵鷿 ���� 
	public DefaultMid	avm;
//	======================================================================================
	// �� ������Ʈ Ŭ���� ���� 
	public Intro			intro;
	public Logo				logo;
	public Menu				menu;
	public Play				play;
//	======================================================================================
	// ���� ��� Ŭ���� ���� 
	private Thread				thread;
//	======================================================================================
	// �� ���Ӻ� ������Ʈ�� ���� ������Ʈ 
	public int GameState;
	public int InnerState;
//	======================================================================================
	// ������ ������ 
	public int m_Speed = 20;
//	======================================================================================
	// �������� ������ �ӵ��� ����ϱ� ���� ������
	public long m_tCurrentTime;
	public long m_tCurrentTimeOld;
	public boolean b_Run;
//	======================================================================================
	// LCD SIZE
	public short nSXS;					// LCD ���� 
	public short nSYS;					// LCD ����
	public short nCXS;					// LCD ����/2
	public short nCYS;					// LCD ����/2
//	======================================================================================
	// �׷��� ȭ�� ������ ���� ����
	public static final int G_TL = Graphics.TOP | Graphics.LEFT;
//	======================================================================================
	// ���� �ʱ�ȭ 
	private void InitGame()
	{
		nSXS = (short) getWidth();					// LCD ���� 
		nSYS = (short) (getHeight() + 16);			// LCD ����
		nCXS = (short) (nSXS >> 1);					// LCD ����/2
		nCYS = (short) (nSYS >> 1);					// LCD ����/2
		
		Configs.x = (short) (nCXS - (176 / 2));
		Configs.y = (short) (nCYS - (178 / 2));
		
		Configs.pages = new boolean[10];
		
		intro = new Intro(this);		// ��Ʈ�� ȭ��
		logo = new Logo(this);			// �ΰ� ȭ��
		menu = new Menu(this);			// �޴� ȭ��
	}
 
	public MainCanvas(DefaultMid avm) 
	{
		this.avm = avm;
		
		InitGame();
		
		ThreadStart();
	}

	public void	ThreadStart()
	{
		b_Run = true;
		thread = new Thread(this);
		thread.start();
	}

	public void	ThreadStop()
	{
		b_Run = false;
		if(thread != null)
			thread = null;
	}

	public void run() 
	{
		long tm;
		m_tCurrentTime = System.currentTimeMillis();		
		m_tCurrentTimeOld = m_tCurrentTime;
		
		while (b_Run){
			nKey = getKeyStates(nKey);
			
			repaint(Configs.x, Configs.y, 176, 178);
			
			m_tCurrentTime =System.currentTimeMillis();
			tm = m_tCurrentTime -m_tCurrentTimeOld;
			
			if (m_Speed > tm)
				tm = m_Speed - tm;
			
			if (tm < 10)
				tm = 10; 
			else if(tm > m_Speed) 
				tm = m_Speed;
			try 
			{
				Thread.sleep(tm); 
			}
			catch(Exception ie)
			{ }
			m_tCurrentTimeOld =m_tCurrentTime +tm;
		}
	}

	protected void paint(Graphics g)
	{
		Font old = g.getFont();
		Font font = Font.getFont(Font.FACE_PROPORTIONAL, Font.SIZE_MEDIUM, Font.STYLE_PLAIN & Font.STYLE_BOLD);
		g.setFont(font);
		
		switch(GameState)
		{
		case Define.INTRO:
			INTRO_FC(g);
			break;
		case Define.LOGO:
			LOGO_FC(g);
			break;
		case Define.MENU:
			MENU_FC(g);
			break;
		case Define.PLAY:
			PLAY_FC(g);
			break;
		}
		g.setColor(0x000000);
		
		g.fillRect(0, 0, nSXS, Configs.y);
		g.fillRect(Configs.x + 176, 0, nSXS, nSYS);
		g.fillRect(Configs.x + 176, Configs.y + 178, Configs.x, Configs.y);
		g.fillRect(0, Configs.y, Configs.x, nSYS);
		
		g.setFont(old);
	}
	
	private void INTRO_FC(Graphics g)
	{
		switch(InnerState)
		{
		case IN_START:
			intro.Start(g);		
			break;
			
		case IN_LOOP:
			intro.Key();
			intro.Draw(g);
			break;
			
		case IN_END:
			intro.End(g);
			break;
		}
	}
	
	private void LOGO_FC(Graphics g) 
	{
		switch(InnerState)
		{
		case IN_START:
			logo.Start(g);
			break;
		case IN_LOOP:
			logo.Key();
			logo.Draw(g);
			break;
		case IN_END:
			logo.End(g);
			break;
		}
	}
	
	private void MENU_FC(Graphics g)
	{
		switch(InnerState)
		{
		case IN_START:
			menu.Start(g);
			break;
		case IN_LOOP:
			menu.Key();
			menu.Draw(g);
			break;
		case IN_END:
			menu.End(g);
			break;
		}
	}
	
	private void PLAY_FC(Graphics g)
	{
		switch(InnerState)
		{
		case IN_START:
			play.Start(g);
			break;
		case IN_LOOP:
			play.Key();
			play.Draw(g);
			break;
		case IN_END:
			play.End(g);
			break;
		}
	}

	public void InnerState(int state)
	{
		InnerState = state;
	}

	public void GameState(int state)
	{
		GameState = state;
	}
}