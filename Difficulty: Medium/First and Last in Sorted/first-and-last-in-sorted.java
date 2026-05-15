class Solution {
    ArrayList<Integer> find(int arr[], int x) {
        // code here
        int start = 0;
        int end = arr.length-1;
        
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]==x){
                int left = findleft(arr,x,mid);
                int right = findright(arr,x,mid);
                ArrayList<Integer> ans = new ArrayList<>();
                ans.add(left);
                ans.add(right);
                return ans;
            }
            else if(arr[mid]<x){
                start= mid+1;
            }
            else{
                end= mid-1;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(-1);
        ans.add(-1);
        return ans;
    }
    
    int findleft(int arr[], int x, int mid){
        if(mid==0){
            return mid;
        }
        if(arr[mid-1]!=x){
            return mid;
        }
        int start = 0;
        int end = mid;
        while(start<=end){
            mid = start+(end-start)/2;
           
            if(arr[mid]==x){
                 if(mid==0){
                return mid;
            }
                end= mid-1;
            }
            else{
                if(arr[mid+1]==x){
                    return mid+1;
                }
                start = mid+1;
            }
        }
        return -1;
    }
    
    int findright(int arr[], int x, int mid){
        if(mid==arr.length-1){
            return mid;
        }
        if(arr[mid+1]!=x){
            return mid;
        }
        int start = mid;
        int end = arr.length-1;
        while(start<=end){
            mid = start+(end-start)/2;
           
            if(arr[mid]==x){
                 if(mid==arr.length-1){
                return mid;
            }
                start= mid+1;
            }
            else{
                if(arr[mid-1]==x){
                    return mid-1;
                }
                end = mid-1;
            }
        }
        return -1;
    }
    
}
