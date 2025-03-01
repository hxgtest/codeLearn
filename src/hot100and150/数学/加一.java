package hot100and150.数学;

/**
 * @author hxg
 * @description: 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * @date 2025/3/1 11:31
 */
public class 加一 {
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]!=9){
                for(int j=i+1;j<digits.length;j++){
                    digits[j]=0;
                }
                digits[i]++;
                return digits;
            }
        }
        digits= new int[digits.length+1];
        digits[0]=1;
        return digits;
    }
}
