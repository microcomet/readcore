package com.cleanread.util;

import java.io.IOException;
import java.io.InputStream;

public class IOUtils {
	
	public static void closeSecurity(InputStream is){
		try {
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
