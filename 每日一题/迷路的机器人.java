/*
设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角移动到右下角的路径。



网格中的障碍物和空位置分别用 1 和 0 来表示。

返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。如果没有可行的路径，返回空数组。

示例 1:

输入:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
输出: [[0,0],[0,1],[0,2],[1,2],[2,2]]
解释: 
输入中标粗的位置即为输出表示的路径，即
0行0列（左上角） -> 0行1列 -> 0行2列 -> 1行2列 -> 2行2列（右下角）
说明：r 和 c 的值均不超过 100。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/robot-in-a-grid-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution {
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return new ArrayList<>();
        find = false;
        List<List<Integer>> res = new ArrayList<>();
        if (obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1)
            return res;
        obstacleGrid[0][0] = 1;
        backTrack(obstacleGrid, 0, 0, res);
        if (res.size()==1){
            if (obstacleGrid.length == 1 && obstacleGrid[0].length == 1) {
                return res;
            } else res.clear();
        }
        return res;
    }

    boolean find;
    int[][] dir = new int[][]{ {0, 1}, {1, 0}};

    public void backTrack(int[][] grid, int x, int y, List<List<Integer>> res) {
        ArrayList<Integer> pos = new ArrayList<>();
        pos.add(x);
        pos.add(y);
        res.add(pos);

        if (find) return;
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            find = true;
            return;
        }
        for (int i = 0; i < 2; i++) {
            int newX = dir[i][0] + x;
            int newY = dir[i][1] + y;
            if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length || grid[newX][newY] == 1)
                continue;
            grid[newX][newY] = 1;
            backTrack(grid, newX, newY, res);
            if (find) return;
            else res.remove(res.size() - 1);
            grid[newX][newY] = 0;
        }
    }
}
	