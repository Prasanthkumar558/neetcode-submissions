class Solution {
    class Task{
        int frequency;
        int timeExecution;
        Task(int f,int t){
            frequency = f;
            timeExecution = t;
        }

    }
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> mp = new HashMap<>();
        for(int i=0;i<tasks.length;i++){
            mp.put(tasks[i],mp.getOrDefault(tasks[i],0)+1);
        }
        PriorityQueue<Task> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.frequency,a.frequency));
        for(char ch : mp.keySet()){
            int val = mp.get(ch);
            pq.add(new Task(val,0));
        }
        Queue<Task> q = new LinkedList<>();

        int time=0;
        while(!pq.isEmpty() || !q.isEmpty()){
            time++;
            if(!pq.isEmpty()){
            Task obj = pq.poll();
            obj.frequency--;
            if(obj.frequency > 0){
                obj.timeExecution = time + n;
                q.add(obj);
            }
            }

            if(q.size() > 0 && q.peek().timeExecution == time){
                pq.add(q.poll());
            }
        }
        return time;
    }
}
