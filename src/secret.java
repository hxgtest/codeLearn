import java.util.Arrays;
import java.util.Scanner;

public class secret {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while (in.hasNext()){
            int T=in.nextInt();
            while (T-->0){
                solve(in);
            }
        }
    }
    private static void solve(Scanner in){
        int C=in.nextInt();
        int[] operations=new int[C];
        for(int i=0;i<C;i++){
            operations[i]=in.nextInt();
        }
        int m=in.nextInt(),n=in.nextInt();
        int[][] dashboard=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dashboard[i][j]=in.nextInt();
            }
        }
        for(int i=0;i<C;i++){
            int operation=operations[i];
            switch (operation){
                case 0:
                    up(dashboard,m,n);
                    break;
                case 1:
                    down(dashboard,m,n);
                    break;
                case 2:
                    left(dashboard,m,n);
                    break;
                case 3:
                    right(dashboard,m,n);
                    break;
                default:
                    break;
            }
        }
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                System.out.print(dashboard[i][j]+" ");
            }
            System.out.println();
        }
    }
    private static void up(int[][] dashboard,int m,int n){
        boolean[][] isNotChange=new boolean[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(isNotChange[i],true);
        }
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                if(dashboard[i][j]!=0){
                    int targetI=i-1;
                    while (targetI>=0){
                        if(dashboard[targetI][j]==0){
                            targetI--;
                        }else {
                            break;
                        }
                    }
                    if(targetI==-1){
                        dashboard[0][j]=dashboard[i][j];
                        dashboard[i][j]=0;
                    }else if(isNotChange[targetI][j]&&dashboard[targetI][j]==dashboard[i][j]){
                        dashboard[targetI][j]=dashboard[targetI][j]*2;
                        isNotChange[targetI][j]=false;
                        dashboard[i][j]=0;
                    }else {
                        dashboard[targetI+1][j]=dashboard[i][j];
                        dashboard[i][j]=0;
                    }
                }
            }
        }
    }
    private static void down(int[][] dashboard,int m,int n){
        boolean[][] isNotChange=new boolean[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(isNotChange[i],true);
        }
        for(int i=m-2;i>=0;i--){
            for(int j=0;j<n;j++){
                if(dashboard[i][j]!=0){
                    int targetI=i+1;
                    while (targetI<m){
                        if(dashboard[targetI][j]==0){
                            targetI++;
                        }else {
                            break;
                        }
                    }
                    if(targetI==m){
                        dashboard[m-1][j]=dashboard[i][j];
                        dashboard[i][j]=0;
                    }else if(isNotChange[targetI][j]&&dashboard[targetI][j]==dashboard[i][j]){
                        dashboard[targetI][j]=dashboard[targetI][j]*2;
                        isNotChange[targetI][j]=false;
                        dashboard[i][j]=0;
                    }else {
                        dashboard[targetI-1][j]=dashboard[i][j];
                        dashboard[i][j]=0;
                    }
                }
            }
        }
    }
    private static void left(int[][] dashboard,int m,int n){
        boolean[][] isNotChange=new boolean[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(isNotChange[i],true);
        }
        for(int j=1;j<n;j++){
            for(int i=0;i<m;i++){
                if(dashboard[i][j]!=0){
                    int targetJ =j-1;
                    while (targetJ >=0){
                        if(dashboard[i][targetJ]==0){
                            targetJ--;
                        }else {
                            break;
                        }
                    }
                    if(targetJ ==-1){
                        dashboard[i][0]=dashboard[i][j];
                        dashboard[i][j]=0;
                    }else if(isNotChange[i][targetJ]&&dashboard[i][targetJ]==dashboard[i][j]){
                        dashboard[i][targetJ]=dashboard[i][targetJ]*2;
                        isNotChange[i][targetJ]=false;
                        dashboard[i][j]=0;
                    }else {
                        dashboard[i][targetJ+1]=dashboard[i][j];
                        dashboard[i][j]=0;
                    }
                }
            }
        }
    }
    private static void right(int[][] dashboard,int m,int n){
        boolean[][] isNotChange=new boolean[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(isNotChange[i],true);
        }
        for(int j=n-2;j>=0;j--){
            for(int i=0;i<m;i++){
                if(dashboard[i][j]!=0){
                    int targetJ =j+1;
                    while (targetJ >=0){
                        if(dashboard[i][targetJ]==0){
                            targetJ++;
                        }else {
                            break;
                        }
                    }
                    if(targetJ ==n){
                        dashboard[i][targetJ-1]=dashboard[i][j];
                        dashboard[i][j]=0;
                    }else if(isNotChange[i][targetJ]&&dashboard[i][targetJ]==dashboard[i][j]){
                        dashboard[i][targetJ]=dashboard[i][targetJ]*2;
                        isNotChange[i][targetJ]=false;
                        dashboard[i][j]=0;
                    }else {
                        dashboard[i][targetJ-1]=dashboard[i][j];
                        dashboard[i][j]=0;
                    }
                }
            }
        }
    }
}
