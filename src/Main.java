import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            int t = in.nextInt();
            while (t>0){
                t--;
                String s=in.nextLine();
                int sLen=s.length();
                int p=0;
                StringBuilder sb=new StringBuilder();
                char[] chars=s.toCharArray();
                for(int n=0;n<chars.length;n++){
                    if(chars[n]>='0'&&chars[n]<='9'){
                        int i=chars[n]-'0';
                        if(p==0){
                            p=i;
                        }else {
                            p=p*10+i;
                        }
                    }else {
                        String newS=chars.toString();
                        newS= newS.substring(sLen-p&sLen+1,sLen)+newS.substring(0,sLen-p%sLen);
                        chars=newS.toCharArray();
                        if (chars[n]=='R'){

                        }
                    }
                }
            }
        }
    }
}