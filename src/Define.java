import javax.microedition.lcdui.*;

//
// 정의 클래스 - Canvas 상속
//
public class Define extends Canvas
{	
	public static final byte INTRO			=	0;
	public static final byte LOGO			=	1;
	public static final byte MENU			=	2;
	public static final byte PLAY			=	3;
	
	protected void paint(Graphics arg0)
	{
		
	}

	// 스테이트 이동시 전 스탯 이동, 다음 스탯 이동
	public static final int NEXT			=	1;
	public static final int PREV			=	-1;

//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	public static final int _X			=	0;
	public static final int _Y				=	1;
	public static final int _W			=	2;
	public static final int _H			=	3;

//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// Inner State
	public static final int IN_START	=	0;
	public static final int IN_LOOP		=	1;
	public static final int IN_END		=	2;
	
//	======================================================================================
//	 KEY 
//	======================================================================================
	public static final int KEY_NONE = 0;
	public static final int KEY_NUM0 = 48;
	public static final int KEY_NUM1 = 49;
	public static final int KEY_NUM2 = 50;
	public static final int KEY_NUM3 = 51;
	public static final int KEY_NUM4 = 52;
	public static final int KEY_NUM5 = 53;
	public static final int KEY_NUM6 = 54;
	public static final int KEY_NUM7 = 55;
	public static final int KEY_NUM8 = 56;
	public static final int KEY_NUM9 = 57;
	public static final int KEY_STAR = 42;
	public static final int KEY_POUND = 35;
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	//	 	SK-VM Specific
	public static final int KEY_CLR = 8;
	public static final int KEY_COML = 129;
	public static final int KEY_COMC = 130;
	public static final int KEY_OK = 131;
	public static final int KEY_UP = 141;
	public static final int KEY_LEFT = 142;
	public static final int KEY_RIGHT = 145;
	public static final int KEY_DOWN = 146;
	public static final int KEY_FIRE = 148; 
	public static final int KEY_CALL = 190;
	public static final int KEY_END = 191;
	public static final int KEY_FLIP_OPEN = 192;
	public static final int KEY_FLIP_CLOSE = 193; 
	public static final int KEY_VOL_UP = 194;
	public static final int KEY_VOL_DOWN = 195;
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	public int KeyPress;
	public int KeyRelease;
	public int nKey;
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// KEY PRESS
	protected void keyPressed(int keyCode)
	{
		if(keyCode < 0) 
			keyCode = getGameAction(keyCode);
		
		if (KeyPress == 0)
		{
			KeyPress = 1;
			KeyRelease = 0;
			nKey = keyCode;
		}
	}
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// KEY RELEASE
	protected void keyReleased(int keyCode)
	{
		//if (KeyPress == 1)
		//{
		//	KeyRelease = 1;
		//}
       //else 
       //{
       		KeyRelease = 0;
       		KeyPress = 0;
       		nKey	= 0;
		//}
	}
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// KEY STATE
	public int getKeyStates(int oldkey)
	{ 
		int k =nKey; 	
		
		if (KeyPress ==1 || KeyPress ==3)
		{
			if (KeyPress ==3)
				KeyPress =0; 
			else
				KeyPress =2;
			return k;
		}
		else if (KeyPress ==2) 
			return oldkey;
				
		return 0; 
	} 
}