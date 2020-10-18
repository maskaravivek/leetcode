
int solution(string &S) {
    
    int n = S.size();
    
    int cnt = 0;
    for(std::string::size_type i=0; i< S.size(); i++) {
        if(S[i] == 'a') {
            cnt++;
        }
    }
    
    if(cnt == 0) {
        return ((n - 2) * (n - 1))/2;
    }
    if(cnt %3 != 0) {
        return 0;
    }
    
    int split = cnt/ 3;
    
    int cnt_a = 0, cnt_b = 0;
    int i=0, j=0;
    
    int result = 1;
    
    while(i< n && cnt > 0) {
        if(S[i] == 'a') {
            cnt_a++;
            cnt--;
        }
        
        if(cnt_a == split) {
            j = i + 1;
            
            while(S[j]!= 'a' && j< n && cnt > 0) {
                cnt_b++;
                j++;
            }
            
            cnt_a = 0;
            
            result = (result * (cnt_b + 1));
            cnt_b = 0;
            i = j-1;
        }
        i++;
    }
    
    return result;
}
