package GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaUtility {
	
	/**
	 * This method will retrun system data in specific formate
	 * @author SRINANDHINI
	 */
	public String getSystemdataInFormate()
	{
		Date d=new Date();
		SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		String Date=sf.format(d);
		
		return Date;
		
	}

}
