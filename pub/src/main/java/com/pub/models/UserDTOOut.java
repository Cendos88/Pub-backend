package com.pub.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTOOut {
    private Integer id;
    private String name;
    private boolean isActive;
    private boolean isAdult;
    private int pocket;

    public UserDTOOut(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.isActive = user.isActive();
        this.isAdult = user.isAdult();
        this.pocket = user.getPocket();
    }
}
