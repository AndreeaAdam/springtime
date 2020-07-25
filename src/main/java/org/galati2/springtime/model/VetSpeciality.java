package org.galati2.springtime.model;

import javax.persistence.*;

@Entity
@Table(name = "vet_speciality")
public class VetSpeciality {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(columnDefinition = "vet_id")
    private int vetId;
    @Column(columnDefinition = "speciality_id")
    private int specialityId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVetId() {
        return vetId;
    }

    public void setVetId(int vet_id) {
        this.vetId = vetId;
    }

    public int getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(int specialityId) {
        this.specialityId = specialityId;
    }
}
