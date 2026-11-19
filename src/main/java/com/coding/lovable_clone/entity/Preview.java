package com.coding.lovable_clone.entity;

import com.coding.lovable_clone.PreviewStatus;
import jakarta.persistence.*;
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
//@Table(name="previews")
public class Preview {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Project project;
    String namespace;
    String podName;
    String previewUrl;
    PreviewStatus status;
    Instant startedAt;
    Instant terminatedAt;
    Instant createdAt;

}
