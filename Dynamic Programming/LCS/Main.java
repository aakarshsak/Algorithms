
import java.io.*;

public class Main {
    public static String lcs(String s1, String s2){
        int p = -1;
        String str1 = "", str2 = "";
        int len = s1.length() > s2.length() ? s1.length() : s2.length();
        for(int i=0;i<len;i++){
            char ch = s1.charAt(i);
            int index = s2.indexOf(ch);
            if(index!=-1){
                str1+=ch;
            }
        }
        for(int i=0;i<len;i++){
            char ch = s2.charAt(i);
            int index = s1.indexOf(ch);
            if(index!=-1){
                str2+=ch;
            }
        }
        for(int i=str1.length();i>0;i--){
            for(int j=0;j+i-1<str1.length();j++){
                
            }
        }
        
        return s;
    }
    public  static void main(String args[]){
        String s1 = "abfgdedskfff";
        String s2 = "bzxrdeffg";
        System.out.println(lcs(s1, s2));
    }
}