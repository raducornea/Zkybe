package com.zkybe.app.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "reported_users")
@IdClass(ReportedUserId.class)
public class ReportedUser implements Serializable {
    @Id
    private Integer userId;

    @Id
    private Integer reportedUserId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reported_user_id", nullable = false, insertable = false, updatable = false)
    private User reportedUser;

    @Column(name = "report_content")
    private String reportContent;

    public ReportedUser(Optional<User> userId, Optional<User> reportedUserId, String content) {
        if (userId.isPresent() && reportedUserId.isPresent()) {
            this.user = userId.get();
            this.reportedUser = reportedUserId.get();
            this.userId = userId.get().getId();
            this.reportedUserId = reportedUserId.get().getId();
            this.reportContent = content;
        }
    }
}
