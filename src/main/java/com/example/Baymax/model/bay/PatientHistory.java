package com.example.Baymax.model.bay;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patient_history")
public class PatientHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private long id;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @Column(name = "modified_by")
    private String modifiedBy;

    @OneToMany(
            mappedBy = "patientHistory",
            cascade = {CascadeType.ALL}
    )
    private List<ImageData> imageData= new ArrayList<>();

    public String addImage(ImageData data){
        if(!this.imageData.contains(data)){
            this.imageData.add(data);
            data.setPatientHistory(this);
        }
        return "Image successfully added";
    }

    public String removeImage(ImageData data){
        if(this.imageData.contains(data)){
            this.imageData.remove(data);
            data.setPatientHistory(null);
        }
        return "Image successfully removed";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
