package com.zkybe.app.presentation.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserPreferencesRequest {
    private Integer id;
    private String theme;
    private Boolean notifications;
}
