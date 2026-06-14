import java.util.ArrayDeque;

class HitCounter {
    ArrayDeque<Integer> q;

    public HitCounter() {
        this.q = new ArrayDeque<>();
    }

    public void hit(int timestamp) {
        q.offer(timestamp);
    }

    public int getHits(int timestamp) {
        while (!q.isEmpty() && timestamp - q.peek() >= 300) {
            q.poll();
        }

        return q.size();
    }
}
