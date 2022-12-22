package com.zkybe.app.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
public class ReportedUserId implements Serializable {
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "reported_user_id")
    private Integer reportedUserId;

    public ReportedUserId(Integer userId, Integer reportedUserId) {
        this.userId = userId;
        this.reportedUserId = reportedUserId;
    }
}
