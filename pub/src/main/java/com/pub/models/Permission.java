package com.pub.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {
    GUEST_READ("guest:read"),
    GUEST_WRITE("guest:write"),
    BARTENDER_READ("bartender:read");
    @Getter
    private final String permission;
}
