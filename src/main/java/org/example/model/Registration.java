package org.example.model;

import jakarta.persistence.*;
import org.example.utils.Enum.StatusEnum;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "registration")
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "UUID")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_idd", nullable = false)
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @Enumerated(EnumType.STRING)
    private StatusEnum statusEnum;

    @Column(precision = 5, scale = 2)
    private BigDecimal finalNote;

    @Column(precision = 5, scale = 2)
    private BigDecimal frequency;

    @OneToOne(mappedBy = "registration", cascade = CascadeType.ALL)
    private Certificate certificate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Room getRooms() {
        return room;
    }

    public void setRooms(Room rooms) {
        this.room = rooms;
    }

    public StatusEnum getStatusEnum() {
        return statusEnum;
    }

    public void setStatusEnum(StatusEnum statusEnum) {
        this.statusEnum = statusEnum;
    }

    public BigDecimal getFinalNote() {
        return finalNote;
    }

    public void setFinalNote(BigDecimal finalNote) {
        this.finalNote = finalNote;
    }

    public BigDecimal getFrequency() {
        return frequency;
    }

    public void setFrequency(BigDecimal frequency) {
        this.frequency = frequency;
    }
}
