package com.zkybe.app.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user_preferences")
public class UserPreferences {
    @Id
    @Column(name = "user_id")
    private Integer id;

    @JsonIgnore
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "theme", nullable = false)
    private String theme;

    @Column(name = "notifications", nullable = false)
    private Boolean notifications;
}
