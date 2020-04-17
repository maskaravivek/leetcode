class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        for(int i =0; i< arr.length; i++) {
            if(arr[i] == 0) {
                for(int j=arr.length-1; j>i; j--) {
                    if(j+1 < arr.length) {
                        arr[j+1] = arr[j];   
                    }
                }
                if(i+1 < arr.length) {
                    arr[i+1] = 0;    
                    i++;
                }
            }
        }
    }
}