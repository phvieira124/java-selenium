package utils;

public class ScreenShotUtils {
	protected String dir;
	protected boolean session = false;
	protected String defaultDir;
	protected static ThreadLocal<ScreenShotUtils> instance = new ThreadLocal<ScreenShotUtils>();

    public static ScreenShotUtils getInstance() {
		
		if (instance == null)
			instance = new ThreadLocal<ScreenShotUtils>();
		
		if(instance.get() == null)
			instance.set(new ScreenShotUtils());

		return instance.get();
		
	}


}
