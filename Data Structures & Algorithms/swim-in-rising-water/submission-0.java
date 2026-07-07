
class Node{ 
    int height;
    int r;
    int c;

    Node(int height,int r,int c) {
        this.height = height;
        this.r = r;
        this.c = c;
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        boolean[][] visited = new boolean[n][n];
        // visited[0][0] = true;
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.height-b.height);
        int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        
        pq.add(new Node(grid[0][0],0,0));
        int max = 0;
        while(!pq.isEmpty()) {
            Node node = pq.poll();

            int height = node.height;
            max = Math.max(max,height);
            if(node.r == n-1 && node.c == n-1) return max;
            if(visited[node.r][node.c]) continue;
            visited[node.r][node.c] = true;
            for(int[] direction : directions) {
                int newRow = direction[0] + node.r;
                int newCol = direction[1] + node.c;

                if(newRow >= 0 && newRow < n &&  newCol >=0 && newCol < n && !visited[newRow][newCol]) {
                    // visited[newRow][newCol] = true;
                    pq.add(new Node(grid[newRow][newCol],newRow,newCol));
                }
            } 
        }
        return -1;
    }
}
