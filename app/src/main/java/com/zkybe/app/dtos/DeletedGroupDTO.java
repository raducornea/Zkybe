package com.zkybe.app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zkybe.app.models.DeletedGroup;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class DeletedGroupDTO {
    @JsonProperty("idGroup")
    private Integer idGroup;

    @JsonProperty("deletionDate")
    private Date deletionDate;

    public DeletedGroupDTO(DeletedGroup deletedGroup) {
        this.idGroup = deletedGroup.getGroupId();
        this.deletionDate = deletedGroup.getDeletionDate();
    }
}
