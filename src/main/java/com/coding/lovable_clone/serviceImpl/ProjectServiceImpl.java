package com.coding.lovable_clone.serviceImpl;

import com.coding.lovable_clone.dto.project.ProjectRequest;
import com.coding.lovable_clone.dto.project.ProjectResponse;
import com.coding.lovable_clone.dto.project.ProjectSummaryResponse;
import com.coding.lovable_clone.entity.Project;
import com.coding.lovable_clone.entity.User;
import com.coding.lovable_clone.mapper.ProjectMapper;
import com.coding.lovable_clone.repository.ProjectRepository;
import com.coding.lovable_clone.repository.UserRepository;
import com.coding.lovable_clone.service.ProjectService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {


    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final ProjectMapper projectMapper;


    @Override
    public List<ProjectSummaryResponse> getUserProject(Long userId) {
        return List.of();
    }

    @Override
    public ProjectResponse getUserProjectById(Long id, Long userId) {
        Optional<Project> project=projectRepository.findAccessibleProjectById(id,userId);
        return projectMapper.toprojectResponse(project);
    }

    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {

        User owner=userRepository.findById(userId).orElseThrow();
      Project project=Project .builder()
              .name(request.projectName())
              .owner(owner)
              .isPublic(false)
              .build();

project=projectRepository.save(project);
return projectMapper.toprojectResponse(Optional.of(project));
    }

    @Override
    public ProjectResponse updateProject(Long id, Long userid, ProjectRequest request) {
        Project project=projectRepository.findAccessibleProjectById(id,userid).orElseThrow(() -> new RuntimeException("Project not found or access denied"));
      project.setName(request.projectName());
      project=projectRepository.save(project);
      return projectMapper.toprojectResponse(Optional.of(project));
    }

    @Override
    public void softDelete(Long id, Long userId) {
        Project project=getAccessibleProjectById(id,userId);
        if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("you are not allowed to delete");
        }
        project.setDeletedAt(Instant.now());
        projectRepository.save(project) ;

    }

    public Project getAccessibleProjectById(Long projectId, Long userId) {

        return projectRepository.findAccessibleProjectById(projectId, userId)
                .orElseThrow(() -> new RuntimeException("Project not found or access denied"));
    }
}

