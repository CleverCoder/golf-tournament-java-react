package com.tournament.golf.dbmodel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tournaments", schema = "public")
public class Tournament {
    @Id
    @ColumnDefault("uuid_generate_v4()")
    @Column(name = "id", nullable = false)
    private UUID id;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "course_pars", nullable = false)
    private List<Integer> coursePars;

    @NotNull
    @Column(name = "total_par", nullable = false)
    private Integer totalPar;
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getCoursePars() {
        return coursePars;
    }

    public void setCoursePars(List<Integer> coursePars) {
        this.coursePars = coursePars;
    }

    public Integer getTotalPar() {
        return totalPar;
    }

    public void setTotalPar(Integer totalPar) {
        this.totalPar = totalPar;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

/*
 TODO [Reverse Engineering] create field to map the 'status' column
 Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @ColumnDefault("'PENDING'")
    @Column(name = "status", columnDefinition = "tournament_status not null")
    private Object status;
*/
}