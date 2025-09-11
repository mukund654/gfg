class Solution {
    int getLPSLength(String s) {
        // code here
       int []hash1 = {0,0};
       int []hash2 = {0,0};
       int mod1 = 1000000007;
       int mod2 = 1000000009;
       int p1 = 1;
       int p2 = 1;
       int base1 = 31;
       int base2 = 37;
       int ans = 0;
       for(int i = 0;i<s.length()-1;i++){
           hash1[0] = (int)((1L*(s.charAt(i)-'a'+1)*p1%mod1)+hash1[0])%mod1;
           hash1[1] = (int)((1L*(s.charAt(i)-'a'+1)*p2%mod2)+hash1[1])%mod2;
           
           hash2[0] = (int)((1L*hash2[0]*base1)%mod1 + s.charAt(s.length()-i-1)-'a'+1)%mod1;
           hash2[1] = (int)((1L*hash2[1]*base2)%mod2 + s.charAt(s.length()-1-i)-'a'+1)%mod2;
           
           p1 = (int)(1L*p1*base1%mod1);
           p2 = (int)(1L*p2*base2%mod2);
           if(hash1[0]==hash2[0] && hash2[1]==hash1[1]){
               ans = i+1;
           }
       }
       return ans;
    }
}