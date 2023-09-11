package cn.giraffetree.benchmark.java.jdk.queue.threadsafe.arrayblock.mpmc;


import cn.giraffetree.benchmark.java.common.NoOperationTask;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 10个producer 1个consumer 场景
 */
@State(Scope.Group)
@BenchmarkMode({Mode.Throughput, Mode.SampleTime})
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class ArrayBlockQueueSceneMpmcTest {

    private ArrayBlockingQueue<NoOperationTask> blockingQueue;

    @Setup
    public void init() {
        blockingQueue = new ArrayBlockingQueue<>(65536);
    }


    @Benchmark
    @Group("p2c2")
    @GroupThreads(2)
    public void offer1() {
        blockingQueue.offer(new NoOperationTask());
    }

    @Benchmark
    @Group("p2c2")
    @GroupThreads(2)
    public void take1() {
        try {
            blockingQueue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Benchmark
    @Group("p4c4")
    @GroupThreads(4)
    public void offer2() {
        blockingQueue.offer(new NoOperationTask());
    }

    @Benchmark
    @Group("p4c4")
    @GroupThreads(4)
    public void take2() {
        try {
            blockingQueue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Benchmark
    @Group("p8c8")
    @GroupThreads(8)
    public void offer3() {
        blockingQueue.offer(new NoOperationTask());
    }

    @Benchmark
    @Group("p8c8")
    @GroupThreads(8)
    public void take3() {
        try {
            blockingQueue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Benchmark
    @Group("p16c16")
    @GroupThreads(16)
    public void offer4() {
        blockingQueue.offer(new NoOperationTask());
    }

    @Benchmark
    @Group("p16c16")
    @GroupThreads(16)
    public void take4() {
        try {
            blockingQueue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Benchmark
    @Group("p32c32")
    @GroupThreads(32)
    public void offer8() {
        blockingQueue.offer(new NoOperationTask());
    }

    @Benchmark
    @Group("p32c32")
    @GroupThreads(32)
    public void take8() {
        try {
            blockingQueue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Benchmark
    @Group("p64c64")
    @GroupThreads(64)
    public void offer16() {
        blockingQueue.offer(new NoOperationTask());
    }

    @Benchmark
    @Group("p64c64")
    @GroupThreads(64)
    public void take16() {
        try {
            blockingQueue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Benchmark
    @Group("p8c4")
    @GroupThreads(8)
    public void offer84() {
        blockingQueue.offer(new NoOperationTask());
    }

    @Benchmark
    @Group("p8c4")
    @GroupThreads(8)
    public void take84() {
        try {
            blockingQueue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws RunnerException {
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        Options opt = new OptionsBuilder()
                .include(ArrayBlockQueueSceneMpmcTest.class.getSimpleName())
                .forks(1)
                .result(ArrayBlockQueueSceneMpmcTest.class.getSimpleName() + "_" + now + ".json")
                .resultFormat(ResultFormatType.JSON)
                .build();
        new Runner(opt).run();
    }

}
