package com.gxf.spring.jiemi.chapter9;

import org.springframework.aop.TargetSource;

/**
 * Created by 58 on 2018/3/31.
 */
public class AlternativeTargetSource implements TargetSource {
    private ITask alternativeTaskOne;
    private ITask alternativeTaskTwo;
    private int counter;

    public AlternativeTargetSource(ITask alternativeTaskOne, ITask alternativeTaskTwo) {
        this.alternativeTaskOne = alternativeTaskOne;
        this.alternativeTaskTwo = alternativeTaskTwo;
    }

    @Override
    public Class<?> getTargetClass() {
        return ITask.class;
    }

    @Override
    public boolean isStatic() {
        return false;
    }

    @Override
    public Object getTarget() throws Exception {
        try{
            if(counter % 2 == 0){
                return alternativeTaskTwo;
            }else{
                return alternativeTaskOne;
            }
        }finally {
            counter++;
        }
    }

    @Override
    public void releaseTarget(Object target) throws Exception {

    }
}
