import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        int[] sum =new int[t];
        int[] prefix=new int[1000001];
        prefix[0]=0;
        for(int i=1;i<1000001;i++){
            if(check(i)){
                prefix[i]=prefix[i-1]+1;
            }else {
                prefix[i]=prefix[i-1];
            }
        }
        for(int i=0;i<t;i++){
            int l=in.nextInt();
            int r=in.nextInt();

            sum[i]=prefix[r]-prefix[l-1];
        }

        for(int num: sum){
            System.out.println(num);
        }
    }
    static boolean check(int num){
        int temp=num;
        int count=0;
        while (num>0){
            count+=num%10;
            num/=10;
        }
        return temp%count==1;
    }
}