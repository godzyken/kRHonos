package com.krhonos.calendar.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
@Table(name="events")
@JsonIgnoreProperties({ "range" })
public class Planning {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonProperty(value = "start")
    @Column(name = "timestart")
    private LocalTime timeStart;

    @JsonProperty(value = "end")
    @Column(name = "timeend")
    private LocalTime timeEnd;

    @JsonProperty(value = "recurrent")
    @Column(name = "dow")
    private int recurrent;

    // @JsonIgnore
    @JsonProperty(value = "range_start")
    @Column(name = "date_start")
    private LocalDate dateStart;

    @JsonProperty(value = "range_end")
    @Column(name = "date_end")
    private LocalDate dateEnd;

    @JsonProperty(value = "frequency")
    @Column(name = "frequency")
    private int frequency;

    @Transient
    private int dow[];

    @Transient
    private Ranges range[];

    public Planning(LocalTime timeStart, LocalTime timeEnd, int recurrent, LocalDate dateStart, LocalDate dateEnd, int frequency) {
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.recurrent = recurrent;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.frequency = frequency;
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

    public Ranges[] getRange() {
        return range;
    }

    public void setRange(Ranges[] range) {
        this.range = range;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
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
