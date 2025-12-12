package roykar;

import java.util.Comparator;

public class HuffmanComparator implements Comparator<HuffmanNode>{

	

	@Override
	public int compare(HuffmanNode arg0, HuffmanNode arg1) {
		
		return arg0.freq-arg1.freq;
	}

}
