package url;

import java.util.Random;

public class RandomShortnerStrategy implements ShortnerStrategy{

	private static final int NUM_CHARS = 7;
	private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	private Random random ;
	private DB db;
	
	public RandomShortnerStrategy() {
		random = new Random();
		db = new DB();
	}
	
	@Override
	public String getShortURL(String longURL) {
	
		char[] urlChars = new char[NUM_CHARS];
		
		while(true) {
			
//			int randomIndex = random.nextInt(ALPHABET.length());
			for(int i=0;i<NUM_CHARS;i++) {
				int randomIndex = random.nextInt(ALPHABET.length());
				urlChars[i] = ALPHABET.charAt(randomIndex);
			}
			
			String shortURLString = new String(urlChars);
			
			if(!db.isKeyExists(shortURLString)) {
				db.map.put(shortURLString, longURL);
				return shortURLString;
			}
			
		}
	}

}
