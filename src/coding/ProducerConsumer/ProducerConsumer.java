import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ProducerConsumer {
	public static void main(String[] args) {
		Q q = new Q(20);
		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			threads.add(new Thread(new Producer(q)));
		}
		for (int i = 0; i < 100; i++) {
			threads.add(new Thread(new Consumer(q)));
		}
		for (Thread t : threads) {
			t.start();
		}
	}
}

class Producer implements Runnable {
	Q q;

	public Producer(Q q) {
		super();
		this.q = q;
	}

	@Override
	public void run() {
		q.put(0);
	}
}

class Consumer implements Runnable {
	Q q;

	public Consumer(Q q) {
		super();
		this.q = q;
	}

	@Override
	public void run() {
		System.out.println(q.take());
	}
}

class Q {
	private Queue<Integer> q;
	private final int limit;

	public Q(int limit) {
		q = new LinkedList<>();
		this.limit = limit;
	}

	public synchronized void put(Integer ele) {
		if (q.size() == limit) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		if (q.size() == 0) {
			notifyAll();
		}
		q.offer(ele);
	}

	public synchronized Integer take() {
		while (q.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		if (q.size() == limit) {
			notifyAll();
		}
		return q.poll();
	}
}


