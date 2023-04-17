package assignment2.problem1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestPermut {

  public static void main(String[] args) {
    String s = "aabc";
    List<String> result = new ArrayList<>();

    if(s.length() > 1)
      createPermut(s,Character.toString(s.charAt(0)),1,result);
    else
      result.add(s);

    Collections.sort(result);

    Set<String> set = new HashSet<>(result);
    for(String str: set)
      System.out.println(str);
  }

  //ab -> ba, ab
  //abc -> ba, ab, cba, bca, bac
  private static void createPermut(String original, String s1, int index, List<String> result){
    if(s1.length() == original.length()){
      result.add(s1);
      return;
    }

    for(int i=0;i<s1.length()+1;i++){
      String s2 = s1.substring(0,i) + original.charAt(index) + s1.substring(i);
      //System.out.println("s2 : "+s2 + " i : "+i);
      createPermut(original,s2,index+1,result);
    }
  }
}
