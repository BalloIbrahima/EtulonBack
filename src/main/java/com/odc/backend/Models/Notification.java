package com.odc.backend.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Notification {
    
    @Id
    @Column(name = "conseil_id")
    private Long id;

    @Lob
    private String description;

    //...
    @OneToOne
    @MapsId
    @JoinColumn(name = "conseil_id")
    private Conseil conseil;
}
