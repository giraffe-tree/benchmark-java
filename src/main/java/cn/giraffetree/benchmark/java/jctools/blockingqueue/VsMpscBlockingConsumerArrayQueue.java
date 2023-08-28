package cn.giraffetree.benchmark.java.jctools.blockingqueue;

import org.jctools.queues.MpscBlockingConsumerArrayQueue;

public class VsMpscBlockingConsumerArrayQueue {

    public static void main(String[] args) {

        MpscBlockingConsumerArrayQueue<Long> queue = new MpscBlockingConsumerArrayQueue<>(1024 * 64);

    }

}
