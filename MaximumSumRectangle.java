public class MaximumSumRectangle {

    public static int maxSum(int a[][], int m, int n) {
        int preSum[][] = new int[m+1][n];
        int max = -1, min = Integer.MAX_VALUE, negRow =0, negCol=0;
        int rStart =0, rEnd = 0, cStart =0, cEnd=0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                preSum[i+1][j] = preSum[i][j] + a[i][j];
            }
        }
        for(int rC =0;rC<m;rC++) { //L
            for(int row =rC;row<m;row++) { //R
                int sum =0, currCStart =0;
                for(int col = 0;col<n;col++) {
                    sum += preSum[row+1][col] - preSum[rC][col];
                    if(sum<0) {
                        if(sum <min) {
                            min = sum;
                            negRow = row;
                            negCol = col;
                        }
                        sum =0;
                        currCStart = col+1;
                    }
                    else if(sum > max) {
                        max = sum;
                        rStart = rC;
                        rEnd = row;
                        cStart = currCStart;
                        cEnd = col;
                    }
                }
            }
        }
        if(max == -1) return min;
        return max;
    }


    public static void main(String args[]) {
        int a[][] = new int[][] { { 1, 2, -1, -4, -20 },
                { -8, -3, 4, 2, 1 },
                { 3, 8, 10, 1, 3 },
                { -4, -1, 1, 7, -6 } };

        System.out.println(maxSum(a, a.length, a[0].length));
    }

}
