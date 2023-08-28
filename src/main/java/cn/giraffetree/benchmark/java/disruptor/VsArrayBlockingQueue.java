package cn.giraffetree.benchmark.java.disruptor;

import cn.giraffetree.benchmark.java.disruptor.impl.MessageEvent;
import cn.giraffetree.benchmark.java.disruptor.impl.MessageEventFactory;
import cn.giraffetree.benchmark.java.disruptor.impl.MessageEventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SleepingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.Executors;

/**
 *
 */
public class VsArrayBlockingQueue {


    public static void main(String[] args) {
        int bufferSize = 1024 * 64;
        MessageEventFactory messageEventFactory = new MessageEventFactory();
        Disruptor<MessageEvent> disruptor = new Disruptor<>(messageEventFactory, bufferSize,
                Executors.defaultThreadFactory(), ProducerType.MULTI, new SleepingWaitStrategy(10, 100));
        disruptor.handleEventsWith(new MessageEventHandler());
        disruptor.start();

        RingBuffer<MessageEvent> ringBuffer = disruptor.getRingBuffer();
        long sequence = ringBuffer.next();
        MessageEvent messageEvent = ringBuffer.get(sequence);
        messageEvent.setContent("hello world");
        ringBuffer.publish(sequence);

    }

}
