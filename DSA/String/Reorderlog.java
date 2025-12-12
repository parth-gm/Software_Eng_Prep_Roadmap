package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Reorderlog {

    public static boolean isDigit(char input_char){
        if(input_char>=48 && input_char<=57){
            return  true;
        }
        return false;
    }
    public static String[] reorderLogFilesv1(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) return cmp;
                return split1[0].compareTo(split2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }
    public static String[] reorderLogFiles(String[] logs) {

        ArrayList<Log> arrLetters=new ArrayList<>();
        ArrayList<String> arrDigits=new ArrayList<>();
        for(int i=0;i<logs.length;i++){
            String[] parts=logs[i].split(" ");
            if(isDigit(parts[1].charAt(0))){
                arrDigits.add(logs[i]);
            }else{
                arrLetters.add(new Log(logs[i]));
            }
        }

        Collections.sort(arrLetters, new Comparator<Log>()
                {

                    public int compare(Log o1, Log o2)
                    {

                        int index=0;
                        while(index<o1.arrlogs.size() && index<o2.arrlogs.size())
                        {
                            int v = o1.arrlogs.get(index).compareTo(o2.arrlogs.get(index));
                            if(v!=0)
                                return v;
                            index++;
                        }
                        if(o2.arrlogs.size() ==o1.arrlogs.size()){
                            return o1.identifier.compareTo(o2.identifier);
                        }
                        if(index==o2.arrlogs.size())
                            return 1;
                        else
                            return -1;
                    }
                }
        );

        int idx=0;
        for(Log lg:arrLetters){
            logs[idx++]=lg.line;
        }

        for(String d:arrDigits){
            logs[idx++]=d;
        }

        return  logs;
    }

    public static void main(String[] args) {
        String[] strings = reorderLogFilesv1(new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"
});
        for(String s:strings){
            System.out.println(s);
        }
    }
}
