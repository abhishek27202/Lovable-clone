package com.coding.lovable_clone.mapper;

import com.coding.lovable_clone.dto.project.ProjectResponse;
import com.coding.lovable_clone.dto.project.ProjectSummaryResponse;
import com.coding.lovable_clone.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
   // ProjectResponse toResponse(Project project);
   @Mapping(source = "name", target = "projectName")
    ProjectResponse toProjectResponse(Project project);
    @Mapping(source="name" , target = "projectName")
    ProjectSummaryResponse toProjectSummaryResponse(Project project);
    List<ProjectSummaryResponse> toListProjectSummaryResponse(List<Project> projects);
}
