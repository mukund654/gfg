class Solution {
    public ArrayList<Integer> findMajority(int[] arr) {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        int fir = -1;
        int sec = -1;
        
        int cnt1 = 0;
        int cnt2 = 0;
        for(int i = 0;i<arr.length;i++){
            if(fir==arr[i]){
                cnt1++;
            }
            else if(sec==arr[i]){
                cnt2++;
            }
            else{
                
                if(cnt1==0){
                    fir = arr[i];
                    cnt1 = 1;
                    
                }
                else if(cnt2==0){
                    sec = arr[i];
                    cnt2 = 1;
                }
                else{
                    cnt1--;
                    cnt2--;
                }
                
            }
            
            
            
        }
        cnt1 = 0;
        cnt2 = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]==fir){
                cnt1++;
            }
            else if(arr[i]==sec){
                cnt2++;
            }
            
        }
        if(cnt1>arr.length/3){
            ans.add(fir);
        }
        if(cnt2>arr.length/3){
            ans.add(sec);
        }
      
        Collections.sort(ans);
        return ans;
    }
}