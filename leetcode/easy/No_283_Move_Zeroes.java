package leetcode.easy;

/**
 * Created by jc on 4/26/2016.
 */

/**
 * difficulty: 5
 */

/**
 * 把一个数组中的0移到最后，其它数字的相对顺序不能变
 *
 * 不允许复制数组
 */
public class No_283_Move_Zeroes {

    /**
     * 就是遍历数组，当一个数为0时，将该0和后面每一个数字都替换，
     * 用zeroFinalIndex作为一个flag,该数后面的数都为0，初始值为nums.length。每有一个数为0，zeroFinalIndex--
     *
     * 注意点：当有连续的0时，两个0替换，替换完成时nums[i]==0，此时i不应该+1.
     *
     * 速度太慢花费了34ms，大部分人1ms搞定
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int zeroFinalIndex=nums.length;
        for(int i=0;i<nums.length;){
            if(nums[i]==0&&i<zeroFinalIndex){
                int j=i+1;
                if(j<zeroFinalIndex&&nums[j]==0){
                    i--;
                }
                while(j<zeroFinalIndex){
                    exch(nums,j-1,j);
                    j++;
                }
                zeroFinalIndex--;
            }
            i++;

        }
    }


    /**
     * 即将不为0的数字和第一个0交换，关键在于找到第一个0的位置 zeroIndex。
     *
     * 首先将zeroIndex设为0，即使该数不为0，也只是自己和自己交换，不影响结果。
     *
     * 当遇到一个数为0，此时zeroIndex等于该数的秩（即第一个0的秩序），等到numsIndex增加到一个不为0的数，和它交换。
     * zeroIndex再+1仍是第一个0所在的位置。因为若只有一个0，则nusm[zeroIndex]和nums[numsIndex]交换后，
     * zeroIndex所在的数仍为0。若有多个0，第一0交换后，zeroIndex++后仍为交换后第一个0所在的位置。
     *
     * 该方法速度较快，1ms
     * @param nums
     */
    public void moveZeroesII(int [] nums){
        for(int zeroIndex=0,numIndex=0;numIndex<nums.length;numIndex++){
            if(nums[numIndex]!=0){
                exch(nums,zeroIndex++,numIndex);
            }
        }

    }


    /**
     * 该方法不符合题意中的就地完成
     * @param nums
     */
    public void moveZeroesIII(int [] nums){
        int [] res=new int[nums.length];

        int index=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                res[index]=nums[i];
                index++;
            }
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=res[i];
        }
    }

    public void exch(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

    public static void main(String[] args){
        int[] data={1,0,2,34,11,0,0,0,7,0};
        No_283_Move_Zeroes test=new No_283_Move_Zeroes();
        test.moveZeroesII(data);
        for(int i:data){
            System.out.println(i);
        }
    }
}
