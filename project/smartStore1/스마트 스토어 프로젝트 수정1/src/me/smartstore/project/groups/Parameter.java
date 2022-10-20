package me.smartstore.project.groups;

import java.util.Objects;

public class Parameter {
    private int minimumSpentTime;
    private int minimumTotalPat;

    public Parameter() {}

    public Parameter(int minimumSpentTime, int minimumTotalPat) {
        this.minimumSpentTime = minimumSpentTime;
        this.minimumTotalPat = minimumTotalPat;
    }

    public int getMinimumSpentTime() {
        return minimumSpentTime;
    }

    public void setMinimumSpentTime(int minimumSpentTime) {
        this.minimumSpentTime = minimumSpentTime;
    }

    public int getMinimumTotalPat() {
        return minimumTotalPat;
    }

    public void setMinimumTotalPat(int minimumTotalPat) {
        this.minimumTotalPat = minimumTotalPat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(minimumSpentTime, minimumTotalPat);
    }

    @Override
    public String toString() {
        return "Parameter {" +
                "minimumSpentTime =" + minimumSpentTime +
                "minimumTotalPat =" + minimumTotalPat +
                '}';
    }

}
