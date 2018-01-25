package parser;

/**
 * Created by SretenskyVD on 25.01.2018.
 */
public class testArrays {
    public static void main(String[] args) {
        String Compare ="222";
        String aNums[] = {"111", "222", "333"};
        for (int i = 0; i < aNums.length; i++) {
            String aNum = aNums[i];
            if (aNum != Compare){
                System.out.println("Совпадение 222");
            }
            else {
                System.out.println(aNum);
            }
        }
      
    }
}
