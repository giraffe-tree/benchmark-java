# README

## 使用

```shell
mvn clean package
java -cp target/benchmark-java-0.0.1-SNAPSHOT-jar-with-dependencies.jar cn.giraffetree.benchmark.java.jmh.JMHSample_01_HelloWorld
java -cp target/benchmark-java-0.0.1-SNAPSHOT-jar-with-dependencies.jar cn.giraffetree.benchmark.java.jmh.JMHSample_02_BenchmarkModes
java -cp target/benchmark-java-0.0.1-SNAPSHOT-jar-with-dependencies.jar cn.giraffetree.benchmark.java.jmh.JMHSample_03_States
java -cp target/benchmark-java-0.0.1-SNAPSHOT-jar-with-dependencies.jar cn.giraffetree.benchmark.java.jmh.JMHSample_04_DefaultState

```



## 其他





### JMH 可视化

除此以外，如果你想将测试结果以图表的形式可视化，可以试下这些网站：

JMH Visual Chart：http://deepoove.com/jmh-visual-chart/
JMH Visualizer：https://jmh.morethan.io/