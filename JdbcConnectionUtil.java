package manager;

public class JdbcConnectionUtil {
	private static JdbcConnectionUtil instance;
	
	private JdbcConnectionUtil() {
		
	}
	
	public static JdbcConnectionUtil getInstance() {
		synchronized (JdbcConnectionUtil.class) {
			if(instance == null) {
				instance = new JdbcConnectionUtil();
			}
			
		}
		return instance;
	}

}
