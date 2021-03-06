package com.krhonos.calendrier.model;

import java.time.LocalDate;

public class Range {

    private LocalDate dateStart;
    private LocalDate dateEnd;
    private int frequency;

    public Range() {
    }

    public Range(LocalDate dateStart, LocalDate dateEnd, int frequency) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.frequency = frequency;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "Range{" +
                "dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                '}';
    }
}
