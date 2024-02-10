package com.jdjm.zhy.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LT15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList();
        for(int k = 0;k < nums.length-2;k++){
            if(nums[k] > 0) break;
            //非常狗屎的是 这个判断条件必须写k > 0&&nums[k] == nums[k-1] 才能在力扣里面通过
            if(nums[k] == nums[k+1]) continue;

            int i = k+1;
            int j = nums.length-1;
            while(i < j){
                int sum = nums[k] + nums[i] +nums[j];
                if(sum < 0){
                    while(i < j&&nums[i] == nums[++i]);
                }else if(sum > 0){
                    while(i < j&&nums[j] == nums[--j]);
                }else{
                    list.add(Arrays.asList(nums[k],nums[i],nums[j]));
                    while(i < j&&nums[i] == nums[++i]);
                    while(i < j&&nums[j] == nums[--j]);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        LT15 lt15 = new LT15();
        List<List<Integer>> lists = lt15.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }
}
