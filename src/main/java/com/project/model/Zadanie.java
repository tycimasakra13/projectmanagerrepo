package com.project.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "zadanie")
public class Zadanie {
    @Id
    @GeneratedValue
    @Column(name = "zadanie_id")
    private Integer zadanieId;

    @Column(length = 1000)
    private String opis;

    @Column
    private Integer kolejnosc;
    @Column(nullable = false, length = 50)
    private String nazwa;
    @Column(name = "data_dostarczenia", nullable = false)
    private LocalDateTime dataDostarczenia;
    @ManyToOne
    @JoinColumn(name = "projekt_id")
    private Projekt projekt;

    public Integer getZadanieId() {
        return zadanieId;
    }

    public void setZadanieId(Integer zadanieId) {
        this.zadanieId = zadanieId;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Integer getKolejnosc() {
        return kolejnosc;
    }

    public void setKolejnosc(Integer kolejnosc) {
        this.kolejnosc = kolejnosc;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public LocalDateTime getDataDostarczenia() {
        return dataDostarczenia;
    }

    public void setDataDostarczenia(LocalDateTime dataDostarczenia) {
        this.dataDostarczenia = dataDostarczenia;
    }

    public Projekt getProjekt() {
        return projekt;
    }

    public void setProjekt(Projekt projekt) {
        this.projekt = projekt;
    }
}
