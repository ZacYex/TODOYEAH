package utils;

public class StopWatch {

    // 起始时间(初始化创建)
    private final long timeStart;

    public StopWatch(){
        timeStart = System.currentTimeMillis();
    }

    public long elapsedTime(){
        long spendTime = System.currentTimeMillis() - timeStart;
        return spendTime;
    }
}
