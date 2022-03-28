package com.atlassian.jirabackend.models;

public class HistorySummary {

    private int openCount;
    private int waitingCount;
    private int progressCount;
    private int resolvedCount;

    public HistorySummary() {
    }

    public HistorySummary(int openCount, int waitingCount, int progressCount, int resolvedCount) {
        this.openCount = openCount;
        this.waitingCount = waitingCount;
        this.progressCount = progressCount;
        this.resolvedCount = resolvedCount;
    }

    public int getOpenCount() {
        return openCount;
    }

    public void setOpenCount(int openCount) {
        this.openCount = openCount;
    }

    public int getWaitingCount() {
        return waitingCount;
    }

    public void setWaitingCount(int waitingCount) {
        this.waitingCount = waitingCount;
    }

    public int getProgressCount() {
        return progressCount;
    }

    public void setProgressCount(int progressCount) {
        this.progressCount = progressCount;
    }

    public int getResolvedCount() {
        return resolvedCount;
    }

    public void setResolvedCount(int resolvedCount) {
        this.resolvedCount = resolvedCount;
    }
}
