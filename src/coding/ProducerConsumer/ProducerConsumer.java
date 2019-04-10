package coding.ProducerConsumer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {
	public static void main(String[] args) {
		Q q = new Q2(20);
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
	private Q q;

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
	private Q q;

	public Consumer(Q q) {
		super();
		this.q = q;
	}

	@Override
	public void run() {
		System.out.println(q.take());
	}
}

abstract class Q {
	abstract void put(Integer ele);
	abstract Integer take();
}

class Q1 extends Q {
	private Queue<Integer> q;
	private final int limit;

	public Q1(int limit) {
		q = new LinkedList<>();
		this.limit = limit;
	}

	public synchronized void put(Integer ele) {
		while (q.size() == limit) { // use while because when I woke up, q may still be full
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// q.size() != limit
		if (q.size() == 0) {
			notifyAll();   // we don't want producer notify a producer
		}
		q.offer(ele);   // the order of offer and notifyAll can be changed
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

class Q2 extends Q {
	private Queue<Integer> queue;
	private int limit;
	private Lock lock;
	private Condition full;
	private Condition empty;

	Q2(int limit) {
		queue = new LinkedList<>();
		this.limit = limit;
		lock = new ReentrantLock();
		full = lock.newCondition();
		empty = lock.newCondition();
	}

	public void put(Integer ele) {
		lock.lock();
		try {
			while (queue.size() == limit) {
				full.await();
			}
			if (queue.size() == 0) {
				empty.signalAll();
			}
			queue.offer(ele);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public Integer take() {
		lock.lock();
		try {
			while (queue.size() == 0) {
				empty.await();
			}
			if (queue.size() == limit) {
				full.signalAll();
			}
			return queue.poll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return null;
	}
}
