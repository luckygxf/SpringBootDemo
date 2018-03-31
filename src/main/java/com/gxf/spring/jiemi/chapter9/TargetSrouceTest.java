package com.gxf.spring.jiemi.chapter9;

import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by 58 on 2018/3/31.
 */
public class TargetSrouceTest {
    public static void main(String[] args) {
        ITask task1 = new ITask() {
            @Override
            public void execuuite(TaskExecutionContext ctx) {
                System.out.println("execute in task1");
            }
        };
        ITask task2 = new ITask() {
            @Override
            public void execuuite(TaskExecutionContext ctx) {
                System.out.println("execute in task2");
            }
        };

        TargetSource targetSource = new AlternativeTargetSource(task1, task2);
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTargetSource(targetSource);
        Object proxy = proxyFactory.getProxy();
        ((ITask)proxy).execuuite(null);
        ((ITask)proxy).execuuite(null);
        ((ITask)proxy).execuuite(null);
        ((ITask)proxy).execuuite(null);
        ((ITask)proxy).execuuite(null);
        ((ITask)proxy).execuuite(null);

    }
}
