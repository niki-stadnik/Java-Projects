package testove;

public class arrays {
    public static void main(String[] args) {
        String[] test = {"asd", "qwe", "zxc", "1234"};
        for (String day: test) System.out.println(day);
        System.out.println(".....");
        int longest = 0;
        for(int i=1;i<test.length;++i){
            if (test[i].length()>test[longest].length()){
                longest=i;
            }
        }
        System.out.println(test[longest]);
    }
}
