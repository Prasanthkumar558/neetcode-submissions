class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ans=0.0D;
        int size = nums1.length + nums2.length;
        int[] nums3 = new int[size];
        int i =0 , j = 0 , k = 0;

        while(i < nums1.length && j < nums2.length){
            if(nums1[i] <= nums2[j]){
                nums3[k] = nums1[i];
                i++;
            }
            else{
                nums3[k] = nums2[j];
                j++;
            }
            k++;
        }
        while( i < nums1.length){
            nums3[k] = nums1[i];
            i++;
            k++;
        }
        while( j < nums2.length){
            nums3[k] = nums2[j];
            j++;
            k++;
        }

        if(size%2==1){
            int low = 0,high = nums3.length -1;
            int mid = low + (high - low)/2;
            ans = (double) nums3[mid];
        }
        else{
            int low = 0,high = nums3.length -1;
            int mid = low + (high - low)/2;
            ans =(double) (nums3[mid]+nums3[mid+1])/2;
        }
        return ans;
    }
}
