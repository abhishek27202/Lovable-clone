package com.coding.lovable_clone.controller;

import com.coding.lovable_clone.dto.project.ProjectRequest;
import com.coding.lovable_clone.dto.project.ProjectResponse;
import com.coding.lovable_clone.dto.project.ProjectSummaryResponse;
import com.coding.lovable_clone.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping()
    public ResponseEntity<List<ProjectSummaryResponse>> getProject(){
        Long userId=1L;
        return  ResponseEntity.ok(projectService.getUserProject(userId));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponse> getProjectById(@PathVariable Long id){
        Long userId=1L;
        return ResponseEntity.ok(projectService.getProjectById(id ,userId));
   }
   @PostMapping()
    public ResponseEntity<ProjectResponse> createProject(@RequestBody ProjectRequest request){
        Long userId=1L;
        return ResponseEntity.ok(projectService.createProject(request,userId));
   }
   @PatchMapping("/{id")
    public ResponseEntity<ProjectResponse> updateProject(@PathVariable Long id,@RequestBody ProjectRequest request){
        Long userid=1l;
        return ResponseEntity.ok(projectService.updateProject(id,userid,request));
   }
@DeleteMapping("/{id}")
    public ResponseEntity<Void> softDelete(@PathVariable Long id){
        Long userId=1L;
        return ResponseEntity.noContent().build();
}
}
