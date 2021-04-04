package Framwork.JiraTest.commonLibrary;

import java.io.IOException;
import java.util.Base64;

public class DecryptPassword {
	/*
	 * Decrypt the passowrd to be used in the test case using Base64
	 */
	public static String GetDecryptedPW() throws IOException {

		String decrptData = EncryptPassword.getEncryptedPW();

		byte[] decodeBytes = Base64.getDecoder().decode(decrptData.getBytes());

		String DecodedPW = new String(decodeBytes);

		return DecodedPW;
	}
}