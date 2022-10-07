public class Launcher {

    public static void main(String[] args) {

        //reverse a String--------------------------

        String s = "Hey I'm a String";
        String s2 = "";

        for(int i = s.length() - 1; i >= 0; i--){
            char temp = s.charAt(i);
            s2 += temp;
        }
        System.out.println(s2);



    }
}
