package pattern.binarySearch;

/**
 *  Baisic Binary Search patterns
 */
public class BinarySearch {
    /*
        PATTERN:
        int binarySearch(int[] nums,int target){
        int left = 0,right = ...;

    while(...){
        int mid = (right + left) / 2;
        if(nums[mid] == target){
            ...
        }else if(nums[mid] < target){
            left = ...
        }else if(nums[mid] > target){
            right = ...
        }
    }
    return ...;
}
        pay attention on ...
     */

    /**
     * 1. First case is find the target from input array.
     *
     *
     * @param nums input array
     * @param target number to search
     * @return return first position of that number
     */
    static int binarySearch01(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1; //pay attention
        while (left <= right) { //1st approach interval [3,2] empty interval equal [right+1, right]
            int mid = (right + left)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid +1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return  -1;
    }
    static int binarySearch02(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1; //pay attention
        while (left <  right) { //2st approach interval [2,2], item 2 not checked.
            int mid1 = (right + left)/2;
            if (nums[mid1] == target) {
                return mid1;
            } else if (nums[mid1] < target) {
                left = mid1 +1;
            } else if (nums[mid1] > target) {
                right = mid1 - 1;
            }
        }
        return  nums[left] == target ? left : -1;
    }

    /*
           [1,2,2,2,2,3,4,4]
           left 0, right =8;
           //1
           mid = 4; nums [4] = 2;
           right = 4;
           [1,2,2,2,2]
           //2
           mid = 2;
           nums[2] == 2 -> right = 2;
           //3
           [1, 2, 2]
           mid = 1;
           right = 1;
           //4
           [1,2]
           mid = 0;
           left = 1;
           left == right terminate
           return 1;
     */
    /**
     * use Case 2. Find target in sorted array with repeated occurance. return left boundary. [1,2,2,2,3,4] left is 1;
     * @param nums sorted input array with repeated elements
     * @param target target to search
     * @return left boundary search
     */
    static int leftBound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length; // attention not nums.length - 1
        while (left < right) { // attention not left <= right
            int mid = (left + right) /2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        //return left;
/*        For this array, the algorithm will get result 1. The result 1 can be interpreted this way: there is 1 element in nums which element is less than 2.

        For example, a sorted array nums = [2,3,5,7], target = 1, the alghrithm will return 0, which means there is 0 element in nums which element is less than 1.

        For example, we have same sorted array as described above, and this time we have target = 8, the algorithm will get result 4, which means there is 4 element in nums which element is less than 8.

        In summary, we can see the interval of return value using the alghrithm (which is the value of left) is closed interval [0,nums.length], so we can simply add two line of codes to get -1 result in proper time.
*/
        if (left == nums.length) return -1;
        return nums[left] == target ? left : -1;

    }

    static int rightBound(int[] nums, int target) {
        int left = 0; int right=nums.length;
        while (left < right) {
            int mid = (right + left)/2;
            if (nums[mid] == target) {
                left = mid + 1; //Attention
            } else if (nums[mid]  > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid +1;
            }
        }
        if (left == 0) return -1;
        return nums[left-1] == target ? left-1 : -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch01(new int[]{1,2,3,4,5,6,7,9}, 7));
        System.out.println(binarySearch01(new int[]{1,2,3,4,5,6,7,9}, 10));

        System.out.println(binarySearch02(new int[]{1,2,3,4,5,6,7,9}, 7));
        System.out.println(binarySearch02(new int[]{1,2,3,4,5,6,7,9}, 10));
    }
}
