package com.lc.info.constant;

public enum DevResult {
    UN_DEV(0),
    DEVING(1),
    DEV_FINISHED(2),
    DEV_FAILURE(3);

    private Integer devResult;

    DevResult(Integer devResult) {
        this.devResult = devResult;
    }

    public Integer getDevResult() {
        return devResult;
    }

    public void setDevResult(Integer devResult) {
        this.devResult = devResult;
    }
}
