package com.gxf.spring.jiemi.chapter5;

/**
 * Created by 58 on 2018/3/28.
 */
public enum MethodExecutionStats {
    BEGIN("begin"),
    END("end")
    ;

    private String status;

    MethodExecutionStats(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
