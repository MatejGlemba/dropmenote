package io.dpm.dropmenote.ws.utils;

/**
 * Pomaha zobrazovat error logy
 * 
 * @author Martin Jurek (Starbug s.r.o. | https://www.strabug.eu)
 *
 */
public class LogMessageUtil {

	/**
	 * Ziska celu exception z throwable objektu. Vhodne pre logovanie exceptions do
	 * logov
	 * 
	 * @param e
	 * @return
	 */
	public static String getExceptionMessage(Throwable e) {
		if (e == null) {
			return null;
		}
		
		StringBuilder sb = new StringBuilder("Exception:" + e.getMessage());
		sb.append(System.getProperty("line.separator"));
		sb.append(e.getLocalizedMessage());
		sb.append(System.getProperty("line.separator"));
		sb.append(e.getCause());
		sb.append(System.getProperty("line.separator"));

		for (StackTraceElement ste : e.getStackTrace()) {
			sb.append(ste);
			sb.append(System.getProperty("line.separator"));
		}
		return sb.toString();
	}
}