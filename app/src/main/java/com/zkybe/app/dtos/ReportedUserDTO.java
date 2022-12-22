package com.zkybe.app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zkybe.app.models.ReportedUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReportedUserDTO {
    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("reported_user_id")
    private Integer reportedUserId;

    @JsonProperty("content")
    private String content;

    public ReportedUserDTO(ReportedUser reportedUser) {
        this.userId = reportedUser.getUserId();
        this.reportedUserId = reportedUser.getReportedUserId();
        this.content = reportedUser.getReportContent();
    }
}
