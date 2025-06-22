class Solution {


    public static int forEven(int nums[]){
        int count=0;
        int n = nums.length;
        int i=0; 
        int j=0;
        while(i<n && j<n){         

            if(i%2!=0 && nums[i]%2==0){
                while(j<n){
                    if(j%2==0 && nums[j]%2!=0){
                        nums[j]=2;
                        nums[i]=1;
                        count += Math.abs(j-i);
                        break;
                    }
                    j++;
                }
                
            }

            else if(i%2==0 && nums[i]%2!=0){
                while(j<n){
                    if(nums[j]%2==0 && j%2!=0){
                        nums[j]=1;
                        nums[i]=2;
                        count += Math.abs(i-j);
                        break;
                    }
                    j++;
                }
            }
            i++;
        }

        return count;

    }

    public static int forOdd(int nums[]){
        int count=0;
        int n = nums.length;
        int i=0, j=0;
        while(i<n && j<n){         

            if(i%2!=0 && nums[i]%2!=0){
                while(j<n){
                    if(j%2==0 && nums[j]%2==0){
                        nums[j]=1;
                        nums[i]=2;
                        count += Math.abs(j-i);
                        break;
                    }
                    j++;
                }
                
            }

            else if(i%2==0 && nums[i]%2==0){
                while(j<n){
                    if(nums[j]%2!=0 && j%2!=0){
                        nums[j]=2;
                        nums[i]=1;
                        count += Math.abs(i-j);
                        break;
                    }
                    j++;
                }
            }
            i++;
        }
            return count;
    }


    public int minSwaps(int[] nums) {
        int n = nums.length;
        int even=0;
        int odd=0;
        for(int i=0; i<n; i++){
            if(nums[i]%2==0) even++;
            else odd++;
        }

        if(Math.abs(even-odd)>1) return -1;

        if(even>odd){
            return forEven(nums);
        }

        else if(odd>even){
            return forOdd(nums);
        }
        else {
            int copy[] = new int[n];
            for(int i=0; i<n; i++){
                copy[i]=nums[i];
            }
            return Math.min(forEven(copy), forOdd(nums));
        }

     




    }
}