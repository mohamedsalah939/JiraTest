package Framwork.JiraTest.commonLibrary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;

public class EncryptPassword {

	public static String getEncryptedPW() throws IOException {

		/*
		 * Encrypt the password read from the source file usnig Base64
		 */
		ArrayList<String> data = dataDriven.getData("Login", "Password");
		String encrptData = data.get(0);
		byte[] encodedBytes = Base64.getEncoder().encode(encrptData.getBytes());

		String EncryptedPW = new String(encodedBytes);

		return EncryptedPW;
	}
}
