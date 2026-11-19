package com.coding.lovable_clone.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Builder
//@Table(name="chatSessions")
public class ChatSession {
    Project project;

    User user;

    String title;

    Instant createdAt;
    Instant updatedAt;

    Instant deletedAt;
}
