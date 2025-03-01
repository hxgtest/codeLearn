package hot100and150.位运算;

/**
 * @author hxg
 * @description: 给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
 * @date 2025/3/1 11:08
 */
public class 数字范围按位与 {
    public int rangeBitwiseAnd(int left, int right) {
        int shift=0;
        while (left!=right){
            left>>=1;
            right>>=1;
            shift++;
        }
        return left<<shift;
    }
    public int rangeBitwiseAnd1(int left, int right) {
        while (left<right){
            right&=right-1;
        }
        return right;
    }
}
