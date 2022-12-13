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
@Table(name = "reported_users")
public class ReportedUser {
    @Id
    @Column(name = "user_id")
    private Integer userId;

    @JsonIgnore
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "reported_user_id", nullable = false)
    private User reportedUser;

    @Column(name = "report_content")
    private String reportContent;
}
