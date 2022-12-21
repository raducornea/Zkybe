package com.zkybe.app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zkybe.app.dtos.GroupDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "group_tag")
    private String groupTag;

    @Column(name = "group_picture")
    private Blob groupPicture;

    @Column(name = "group_theme")
    private String groupTheme;

    @Column(name = "secret")
    private Boolean secret;

    @OneToMany(mappedBy = "received")
    private List<Message> messages;

    @JsonIgnore
    @OneToOne(mappedBy = "group", cascade = CascadeType.ALL)
    //@PrimaryKeyJoinColumn
    private DeletedGroup deletedGroup;
    @OneToMany(
            mappedBy = "group",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<UserGroup> users = new ArrayList<>();

    public void removeUser(User user) {
        for (Iterator<UserGroup> iterator = users.iterator();
             iterator.hasNext(); ) {
            UserGroup userGroup = iterator.next();
            if (userGroup.getGroup().equals(this) &&
                    userGroup.getUser().equals(user)) {
                iterator.remove();
                userGroup.getUser().getGroups().remove(userGroup);
                userGroup.setGroup(null);
                userGroup.setUser(null);
            }
        }
    }

    public Group(GroupDTO groupDTO) {
        this.id = groupDTO.getId();
        this.groupPicture = groupDTO.getGroupPicture();
        this.name = groupDTO.getName();
        this.creationDate = groupDTO.getCreationDate();
        this.groupTag = groupDTO.getGroupTag();
        this.groupTheme = groupDTO.getGroupTheme();
        this.secret = groupDTO.getSecret();
    }

}
