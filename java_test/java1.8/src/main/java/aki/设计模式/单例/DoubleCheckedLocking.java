package aki.设计模式.单例;


import aki.common.Instance;

public class DoubleCheckedLocking {
    private volatile Instance instance;

    public Instance getInstance(){
        if (instance==null){
            synchronized (DoubleCheckedLocking.class){
                if (instance==null){
                    instance = new Instance();
                }
            }
        }
        return instance;
    }
}
