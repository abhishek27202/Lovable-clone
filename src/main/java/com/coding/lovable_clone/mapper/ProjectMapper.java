package com.coding.lovable_clone.mapper;

import com.coding.lovable_clone.dto.project.ProjectResponse;
import com.coding.lovable_clone.entity.Project;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
   // ProjectResponse toResponse(Project project);

    ProjectResponse toprojectResponse(Optional<Project> project);
}
