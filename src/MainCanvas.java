import javax.microedition.lcdui.*;

//
// 매인 캔버스 - 제일 처음 시작하는 캔버스
//
public class MainCanvas extends Define implements Runnable
{
//	======================================================================================
	// 미들렛 선언 
	public DefaultMid	avm;
//	======================================================================================
	// 각 스테이트 클래스 선언 
	public Intro			intro;
	public Logo				logo;
	public Menu				menu;
	public Play				play;
//	======================================================================================
	// 내부 사용 클래스 선언 
	private Thread				thread;
//	======================================================================================
	// 각 게임별 스테이트와 내부 스테이트 
	public int GameState;
	public int InnerState;
//	======================================================================================
	// 쓰레드 슬립값 
	public int m_Speed = 20;
//	======================================================================================
	// 쓰레드의 공정한 속도를 계산하기 위한 변수들
	public long m_tCurrentTime;
	public long m_tCurrentTimeOld;
	public boolean b_Run;
//	======================================================================================
	// LCD SIZE
	public short nSXS;					// LCD 가로 
	public short nSYS;					// LCD 세로
	public short nCXS;					// LCD 가로/2
	public short nCYS;					// LCD 세로/2
//	======================================================================================
	// 그래픽 화면 정렬을 위한 변수
	public static final int G_TL = Graphics.TOP | Graphics.LEFT;
//	======================================================================================
	// 어플 초기화 
	private void InitGame()
	{
		nSXS = (short) getWidth();					// LCD 가로 
		nSYS = (short) (getHeight() + 16);			// LCD 세로
		nCXS = (short) (nSXS >> 1);					// LCD 가로/2
		nCYS = (short) (nSYS >> 1);					// LCD 세로/2
		
		Configs.x = (short) (nCXS - (176 / 2));
		Configs.y = (short) (nCYS - (178 / 2));
		
		Configs.pages = new boolean[10];
		
		intro = new Intro(this);		// 인트로 화면
		logo = new Logo(this);			// 로고 화면
		menu = new Menu(this);			// 메뉴 화면
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