#include <bits/stdc++.h>
using namespace std;

// you can write to stdout for debugging purposes, e.g.
// cout << "this is a debug message" << endl;

int solution(vector<int> &A) {
    vector<int> left;
    vector<int> right;
    
    unordered_map<int, int> map;
    
    for(int i=0; i< A.size(); i++) {
        map[A[i]]++;
        
        if(map[A[i]] == 1) {
            left.push_back(A[i]);
        } else if(map[A[i]] == 2) {
            right.push_back(A[i]);
        } 
    }
    
    sort(left.begin(), left.end());
    
    sort(right.begin(), right.end(), greater<int>());
    
    vector<int> spike;
    int last_element = 0;
    
    for(int i=0; i< left.size(); i++) {
        last_element = left[i];
        spike.push_back(left[i]);
    }
    
    for(int i=0; i< right.size(); i++) {
        
        if(last_element ==  right[i]) {
            continue;
        } else {
            spike.push_back(right[i]);    
        }
    }
    
    return spike.size();
}
