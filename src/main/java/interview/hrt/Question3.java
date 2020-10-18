package interview.hrt;

class MaximumAreaSquareUsingTiles {
    public int solution(int M, int N) {
        int area = M + (N * 4);
        
        double sqrt = Math.sqrt(area);
        
        if(sqrt == (int) sqrt) {
            return (int) sqrt; 
        } else {
            return (int) Math.floor(sqrt);
        }
    }
}
