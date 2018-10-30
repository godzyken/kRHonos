package com.krhonos.calendrier.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

@Entity
@Table(name="planning")
@JsonIgnoreProperties({ "range" })
public class Planning {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(value = "id")
    @Column(name = "planning_id")
    private long id;

    @JsonProperty(value = "start")
    @Column(name = "planning_time_start", nullable = false)
    private LocalTime timeStart;

    @JsonProperty(value = "end")
    @Column(name = "planning_time_end", nullable = false)
    private LocalTime timeEnd;

    @JsonProperty(value = "recurrent")
    @Column(name = "planning_dow", nullable = false, columnDefinition = "INT(1)")
    private int recurrent;

    // @JsonIgnore
    @JsonProperty(value = "range_start")
    @Column(name = "planning_date_start", nullable = false)
    private LocalDate dateStart;

    @JsonProperty(value = "range_end")
    @Column(name = "planning_date_end", nullable = false)
    private LocalDate dateEnd;

    @JsonProperty(value = "frequency")
    @Column(name = "planning_frequency", nullable = false, columnDefinition = "INT(1)")
    private int frequency;

    @Column(name="contrat_id", nullable = false)
    private long contratId;

    @Transient
    private int dow[];

    @Transient
    private Range range[];

    public Planning(LocalTime timeStart, LocalTime timeEnd, int recurrent, LocalDate dateStart, LocalDate dateEnd, int frequency, long contratId) {
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.recurrent = recurrent;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.frequency = frequency;
        this.contratId = contratId;
    }

    public Planning() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalTime getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(LocalTime timeStart) {
        this.timeStart = timeStart;
    }

    public LocalTime getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(LocalTime timeEnd) {
        this.timeEnd = timeEnd;
    }

    public int getRecurrent() {
        return recurrent;
    }

    public void setRecurrent(int recurrent) {
        this.recurrent = recurrent;
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

    public int[] getDow() {
        return dow;
    }

    public void setDow(int[] dow) {
        this.dow = dow;
    }

    public Range[] getRange() {
        return range;
    }

    public void setRange(Range[] range) {
        this.range = range;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public long getContratId() {
        return contratId;
    }

    public void setContratId(long contratId) {
        this.contratId = contratId;
    }

    @Override
    public String toString() {
        return "Planning{" +
                "id=" + id +
                ", timeStart=" + timeStart +
                ", timeEnd=" + timeEnd +
                ", recurrent=" + recurrent +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                ", dow=" + Arrays.toString(dow) +
                ", range=" + Arrays.toString(range) +
                '}';
    }
}
