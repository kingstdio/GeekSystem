package tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/***
 * MD5加密类
 * @author shand
 *
 */
public class MD5 {
	
	/***
	 * 获得字符串的MD5值，32位加密
	 * @param str 需要加密的字符串
	 * @return 加密后的字符串
	 */
	public static String getMD5(String str) {
		//静态方法，便于作为工具类   
	        try {  
	            MessageDigest md = MessageDigest.getInstance("MD5");  
	            md.update(str.getBytes());  
	            byte b[] = md.digest();  
	  
	            int i;  
	  
	            StringBuffer buf = new StringBuffer("");  
	            for (int offset = 0; offset < b.length; offset++) {  
	                i = b[offset];  
	                if (i < 0)  
	                    i += 256;  
	                if (i < 16)  
	                    buf.append("0");  
	                buf.append(Integer.toHexString(i));  
	            }  
	            //32位加密  
	            return buf.toString();  
	            // 16位的加密  
	            //return buf.toString().substring(8, 24);  
	        } catch (NoSuchAlgorithmException e) {  
	            e.printStackTrace();  
	            return null;  
	        }  
	  
	    }  
}
