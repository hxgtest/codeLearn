package hot100and150.技巧;
/*给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。*/
public class 只出现一次的数字 {
    public int singleNumber(int[] nums){
//        任何元素与0异或结果还是原来元素
        int single=0;
        for(int i:nums){
            single^=i;
        }
        return single;
    }
}
