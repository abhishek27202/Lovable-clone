package com.coding.lovable_clone.service;

import com.coding.lovable_clone.dto.project.ProjectRequest;
import com.coding.lovable_clone.dto.project.ProjectResponse;
import com.coding.lovable_clone.dto.project.ProjectSummaryResponse;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface ProjectService {

     List<ProjectSummaryResponse> getUserProject(Long userId);

     ProjectResponse getProjectById(Long id, Long userId);

     ProjectResponse createProject(ProjectRequest request, Long userId);

     ProjectResponse updateProject(Long id, Long userid, ProjectRequest request);
}
