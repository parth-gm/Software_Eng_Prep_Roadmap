package url;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class CounterStrategy implements ShortnerStrategy {

	
	private static final int NUM_CHARS = 7;
	private static final String ALPHABETS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	HashMap<String, Integer> shocouter;
	HashMap<Integer, String> countertol;
	static int COUNTER = 0;
	
	public CounterStrategy() {
		shocouter = new HashMap<String, Integer>();
		countertol = new HashMap<Integer, String>();
		 
	}
	
	
	@Override
	public String getShortURL(String longURL) {
		String base62value = base10to62(COUNTER);
		
		shocouter.put(base62value, COUNTER);
		countertol.put(COUNTER, longURL);
		COUNTER++;
		
		return "https://tinyurl.com/"+base62value;
	}
	
	public String getLongFromShortURL(String surl) {
		
		int counter = shocouter.get(surl.substring("https://tinyurl.com/".length()));
		System.out.println(counter);
		return countertol.get(counter);
	}
	
	
	public int base62to10(String s) {
		
		int result =0;
		for(int i=s.length()-1;i>=0;i--) {
			result = result + convert(s.charAt(i))*(int)Math.pow(62, s.length()-1-i);
		}
		return result;
	}
	
	public int convert(char c) {
		if(c>=0 && c<=9) {
			return c-'0';
		}else if(c>='a' && c<='z') {
			return c - 'a' + 10;
		}else if(c>='A' && c<='Z') {
			return c-'A'+36;
		}
		return 0;
	}
	
	//AXZS34
	
	public String base10to62(int n) {
		StringBuffer sb = new StringBuffer();
		
		while(n>0) {
			
			sb.insert(0, ALPHABETS.charAt(n%ALPHABETS.length()));
			n = n/62;
			
		}
		
		while(sb.length()!=7) {
			sb.insert(0, '0');
		}
		
		return sb.toString();
		
		
	}
	
	
	
	static String getMD5Hash(String longURL) {
        try {
            // Create MD5 Hash
            MessageDigest digest = MessageDigest.getInstance("MD5");
  
            byte[] msgDigest = digest.digest(longURL.getBytes());
            
            StringBuilder sb = new StringBuilder();
            for (byte b : msgDigest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
	
	
	

	
	
}
