
public class Search2DMatrix {
	    public boolean searchMatrix(int[][] matrix, int target) {
		int i = 0;
	        for(i=0;i<matrix.length;i++){
	            if(matrix[i][0]==target) return true; 
	            if(matrix[i][0]>target){
	                break;
	            }
	        }
	        if(i==0) return false;
	        for(int c:matrix[i]){
	            if(c==target) return true;
	        }
	        return false;
	    }
}
