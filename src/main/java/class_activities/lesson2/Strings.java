package class_activities.lesson2;

public class Strings {
    public static void main(String[] args) {
        char[] charArr = {'a', 'b', 'c'};
        String str1 = new String(charArr);  // abc
        String str2 = "abc";
        String str3 = "abc";

        System.out.println("abc" == new String("abc")); // returns false as == checks reference(pointer) not the content of it
        System.out.println("abc".equals("abc"));    // return true as it checks content, NOT the reference
        System.out.println(str2 == str3);   // return true as they have the same reference in memory (as there is no new keyword)

        String str4 = "daniz";  // ASCII
        String str5 = "dəniz"; // UTF-8

        System.out.println(str4.getBytes().length); // array of bytes of characters
        System.out.println(str5.getBytes().length);     // will get 6 as 'ə' is taking up 2 bytes

         StringBuilder stringBuilder = new StringBuilder(); // faster but not as safe as StringBuffer and used when there is a multythreading
         StringBuffer stringBuffer = new StringBuffer();    // used when there is one thread



        // formatting
        System.out.printf("%5.3f\n", 2.3);
        System.out.printf("%5s\n", "a");
        // the same with String.format
        System.out.println(String.format("%5s %6s", "a", "b"));

    }
}
