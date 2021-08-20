public class parseInt {


    public static Integer parseInt(String s) {
        int num = 0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                num = num*10 + (s.charAt(i) - '0');
            }
            else throw new NumberFormatException("Invalid string");
        }
        return num;
    }

    public static void main(String args[]) {
        System.out.println(parseInt("123"));
        System.out.println(parseInt("1q3"));
    }
}
