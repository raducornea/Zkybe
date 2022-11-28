package com.zkybe.app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zkybe.app.models.Group;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Blob;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class GroupDTO {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("creationDate")
    private Date creationDate;

    @JsonProperty("groupTag")
    private String groupTag;

    @JsonProperty("groupPicture")
    private Blob groupPicture;

    @JsonProperty("groupTheme")
    private String groupTheme;

    @JsonProperty("isSecret")
    private Boolean secret;

    public GroupDTO(Group group) {
        this.id = group.getId();
        this.name = group.getName();
        this.creationDate = group.getCreationDate();
        this.groupTag = group.getGroupTag();
        this.groupPicture = group.getGroupPicture();
        this.groupTheme = group.getGroupTheme();
        this.secret = group.getSecret();
    }
}
