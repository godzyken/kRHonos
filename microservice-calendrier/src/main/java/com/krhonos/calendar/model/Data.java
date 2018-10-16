package com.krhonos.calendar.model;

import java.util.List;

public class Data {

  private Planning plannings;
  private List<Ranges> ranges;

  public Planning getPlannings() {
    return plannings;
  }

  public void setPlannings(Planning plannings) {
    this.plannings = plannings;
  }

  public List<Ranges> getRanges(){
    return ranges;
  }

  public void setRanges(List<Ranges> ranges) {
    this.ranges = ranges;
  }
}
