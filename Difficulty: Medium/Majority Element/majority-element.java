class Solution {
    int majorityElement(int arr[]) {
        // code here
        int ele = arr[0];
        int cnt = 1;
        if(arr.length==1){
            return arr[0];
        }
        for(int i = 1;i<arr.length;i++){
            if(ele==arr[i]){
                cnt++;
            }
            else{
                if(cnt==0){
                    ele = arr[i];
                    cnt++;
                    continue;
                }
                cnt--;
                
            }
        }
        if(cnt==0){
            return -1;
        }
        else{
            cnt= 0;
            for(int i = 0;i<arr.length;i++){
                if(arr[i]==ele){
                    cnt++;
                }
            }
            if(cnt>arr.length/2){
                return ele;
            }
            else{
                return -1;
            }
        }
        
    }
}