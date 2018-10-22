package com.krhonos.calendar.model;

import javax.persistence.*;

@Entity
@Table(name="contrat__planning")
public class ContratPlanning {
    // @ManyToMany
    @Id
    @Column(name="planning_id")
    private Planning planning;

    @Column(name="contrat_id")
    private long contratId;

    public ContratPlanning() {
    }

    public ContratPlanning(Planning planning, long contratId) {
        this.planning = planning;
        this.contratId = contratId;
    }

    public Planning getPlanning() {
        return planning;
    }

    public void setPlanning(Planning planning) {
        this.planning = planning;
    }

    public long getContratId() {
        return contratId;
    }

    public void setContratId(long contratId) {
        this.contratId = contratId;
    }

    @Override
    public String toString() {
        return "ContratPlanning{" +
                "planning=" + planning +
                ", contratId=" + contratId +
                '}';
    }
}
