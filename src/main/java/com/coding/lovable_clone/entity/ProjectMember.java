package com.coding.lovable_clone.entity;

import com.coding.lovable_clone.ProjectRole;

import java.time.Instant;

public class ProjectMember {
    ProjectMemberId id;
    Project project;
    User user;

    ProjectRole projectRole;
    Instant invitedAt;
    Instant acceptedAt;

}
