package cn.giraffetree.benchmark.java.disruptor.impl;

import com.lmax.disruptor.EventHandler;

public class MessageEventHandler implements EventHandler<MessageEvent> {

    @Override
    public void onEvent(MessageEvent messageEvent, long sequence, boolean end) throws Exception {
        System.out.println("[" + Thread.currentThread().getName() + "]" + "consume: " + messageEvent + ",序号:" + sequence + ", end:" + end);
    }

}
