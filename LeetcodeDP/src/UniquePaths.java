public class UniquePaths {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] pre = new int[m][n];
		initiateArray(pre);
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				pre[i][j] = pre[i - 1][j] + pre[i][j - 1];

			}
		}
		return pre[m][n];

	}

	public static int uniquePathsWithObstacles2(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[] pre = new int[n];
		pre[0] = obstacleGrid[0][0]==1?0:1;
		
		for (int i = 0; i < m; i++) {
			int tempPRE=0;
			for (int j = 0; j < n; j++) {
			    if(j>0){
			        tempPRE=pre[j - 1];
			    }
				if (obstacleGrid[i][j] == 0) {
					pre[j] = pre[j] + tempPRE;
					System.out.println(j+":"+pre[j]);
				} else {
					pre[j] = 0;
				}
			}
		}
		return pre[n - 1];

	}
	
	public static void main(String args[]){
		int[][] obstacleGrid=new int[2][2];
		obstacleGrid[0][0]=0;
		obstacleGrid[1][0]=0;
		obstacleGrid[0][1]=0;
		obstacleGrid[1][1]=0;
		uniquePathsWithObstacles2(obstacleGrid);
	}

	private void initiateArray(int[][] pre) {
		pre[0][0] = 0;
		for (int i = 0; i < pre[0].length; i++) {
			pre[0][i] = 1;
		}
		for (int i = 0; i < pre.length; i++) {
			pre[i][0] = 1;
		}
	}
}
