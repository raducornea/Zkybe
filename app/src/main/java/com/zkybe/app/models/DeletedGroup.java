package com.zkybe.app.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "deleted_groups")
public class DeletedGroup {
    @Id
    @Column(name = "id_group")
    private Integer groupId;

    @JsonIgnore
    @OneToOne
    @MapsId
    @JoinColumn(name = "id_group")
    private Group group;

    @Column(name = "deletion_date")
    private Date deletionDate;
}
