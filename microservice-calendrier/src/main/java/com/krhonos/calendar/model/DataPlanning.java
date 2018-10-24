package com.krhonos.calendar.model;

import java.util.List;

public class DataPlanning {

    private Planning plannings;
    private List<Range> ranges;

    public Planning getPlannings() {
        return plannings;
    }

    public void setPlannings(Planning plannings) {
        this.plannings = plannings;
    }

    public List<Range> getRanges() {
        return ranges;
    }

    public void setRanges(List<Range> ranges) {
        this.ranges = ranges;
    }
}
