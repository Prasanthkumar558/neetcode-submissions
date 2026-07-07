class Node {
    int height;
    int r;
    int c;

    public Node(int height,int r,int c) {
        this.height = height;
        this.r = r;
        this.c = c;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        int[][] distance = new int[rows][cols];
        int[][] neighbours = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.height - b.height);

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                distance[i][j] = (int) 1e8;
            }
        }

        pq.add(new Node(0,0,0));

        while(!pq.isEmpty()) {

            Node node = pq.poll();
            int height = node.height;

            if(node.r == rows-1 && node.c == cols-1)return height;

            for(int[] neighbour : neighbours) {
                int newRow = neighbour[0] + node.r;
                int newCol = neighbour[1] + node.c;

                if(newRow >=0 && newRow < rows && newCol >=0 && newCol < cols) {
                    int newHeight = Math.max(Math.abs(heights[node.r][node.c]-heights[newRow][newCol]),height);
                    
                    if(newHeight < distance[newRow][newCol]) {
                        distance[newRow][newCol] = newHeight;
                        pq.add(new Node(newHeight,newRow,newCol));
                    }
                }
            }
        }
        return -1;
    }
}