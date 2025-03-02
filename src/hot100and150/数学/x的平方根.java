package hot100and150.数学;

/**
 * @author hxg
 * @description: 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 *
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 *
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * @date 2025/3/2 11:17
 */
public class x的平方根 {
    public int mySqrt(int x) {
        int l=0,r=x,ans=-1;
        while (l<=r){
            int mid=l+(r-l)/2;
            if((long)mid*mid<=x){
                ans=mid;
                l=mid+1;
            }else {
                r=mid-1;
            }

        }
        return ans;
    }
}
