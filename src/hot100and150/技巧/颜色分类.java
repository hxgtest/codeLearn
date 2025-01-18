package hot100and150.技巧;

/*给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

必须在不使用库内置的 sort 函数的情况下解决这个问题。*/
public class 颜色分类 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int ptr = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = tmp;
                ptr++;
            }
        }
        for (int i = ptr; i < n; i++) {
            if (nums[i] == 1) {
                int tmp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = tmp;
                ptr++;
            }
        }
    }

    public void sortColors1(int[] nums) {
        int n = nums.length;
        int ptr0 = 0, ptr1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                int tmp = nums[i];
                nums[i] = nums[ptr1];
                nums[ptr1] = tmp;

                ptr1++;
            }
            if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[ptr0];
                nums[ptr0] = tmp;

                if (ptr0 < ptr1) {
                    int tmp1 = nums[i];
                    nums[i] = nums[ptr1];
                    nums[ptr1] = tmp1;
                }
                ptr0++;
                ptr1++;
            }
        }
    }
    public void sortColors2(int[] nums){
        int n=nums.length;
        int p0=0,p2=n-1;
        for(int i=0;i<=p2;i++){
            while(i<=p2&&nums[i]==2){
                int tmp=nums[i];
                nums[i]=nums[p2];
                nums[p2]=tmp;
                p2--;
            }
            if(nums[i]==0){
                int tmp=nums[i];
                nums[i]=nums[p0];
                nums[p0]=tmp;
                p0++;
            }

        }
    }
}
