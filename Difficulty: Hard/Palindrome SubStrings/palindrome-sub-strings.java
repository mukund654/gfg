class Solution {
    public int countPS(String s) {
        // code here
        int ans = 0;
        for(int i = 1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                ans++;
                int left = i-2;
                int right = i+1;
                while(left>=0&&right<s.length()){
                    if(s.charAt(left)==s.charAt(right)){
                        ans++;
                    }
                    else{
                        break;
                    }
                    left--;
                    right++;
                }
                
            }
            if(i<s.length()-1 &&  s.charAt(i-1)==s.charAt(i+1)){
                ans++;
                int left = i-2;
                int right = i+2;
                while(left>=0 && right<s.length()){
                    if(s.charAt(left)==s.charAt(right)){
                        ans++;
                    }
                    else{
                        break;
                    }
                    left--;
                    right++;
                }
            }
            
        }
        return ans;
        
    }
}