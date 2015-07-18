import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

//
// �̵鸴 Ŭ����
//
public class DefaultMid extends MIDlet
{
	Display		display;
	MainCanvas	mc;
	
	public DefaultMid()
	{
		display = Display.getDisplay(this);
		mc = new MainCanvas(this);
	}
	
	public void startApp()
	{ 
		display.setCurrent(mc);
	}

	public void pauseApp()
	{
		
	}
	
	public void resumeApp()
	{
		
	}

	public void destroyApp(boolean b) 
	{
		mc = null;
		display = null;
		System.gc();
	}
}