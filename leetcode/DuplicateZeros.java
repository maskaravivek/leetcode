class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        int possible_duplicates = 0;
        int length = arr.length - 1;
        for(int i =0; i<= length - possible_duplicates; i++) {
            if(arr[i] == 0) {
                if(i == length - possible_duplicates) {
                    arr[length] = 0;
                    length--;
                    break;
                }
                possible_duplicates++;
            }
        }
        
        int last = length - possible_duplicates;
        for(int i = last; i>=0; i--) {
            if(arr[i] == 0) {
                arr[i+possible_duplicates] = 0;
                possible_duplicates --;
                arr[i+possible_duplicates] = 0;               
            } else {
                arr[i+ possible_duplicates] = arr[i]; 
            }
        } 
    }
}