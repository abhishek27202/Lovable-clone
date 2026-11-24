package com.coding.lovable_clone.serviceImpl;

import com.coding.lovable_clone.dto.Member.InviteMemberRequest;
import com.coding.lovable_clone.dto.Member.MemberResponse;
import com.coding.lovable_clone.dto.Member.updateMemberRoleRequest;
import com.coding.lovable_clone.entity.Project;
import com.coding.lovable_clone.entity.ProjectMember;
import com.coding.lovable_clone.entity.ProjectMemberId;
import com.coding.lovable_clone.entity.User;
import com.coding.lovable_clone.mapper.ProjectMemberMapper;
import com.coding.lovable_clone.repository.ProjectMemberRepository;
import com.coding.lovable_clone.repository.ProjectRepository;
import com.coding.lovable_clone.repository.UserRepository;
import com.coding.lovable_clone.service.ProjectMemberService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ProjectMemberServiceImpl implements ProjectMemberService {

    private final  ProjectMemberRepository projectMemberRepository;
    private final  ProjectRepository projectRepository;
    private final  ProjectMemberMapper projectMemberMapper;
    private final UserRepository userRepository;


    @Override
    public List<MemberResponse> getProjectMember(Long projectId, Long userId) {
        Project project= getAccessibleProjectById(projectId,userId);
        List<MemberResponse> memberResponses= new ArrayList<>();
        memberResponses.add(projectMemberMapper.toProjectMemberResponseFromOwner(project.getOwner()));
        memberResponses.addAll(projectMemberRepository.findByIdProjectId(projectId)
        .stream()
        .map(projectMemberMapper::toProjectMemberResponseFromMember)
        .toList());

        return memberResponses;
    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {
        Project project= getAccessibleProjectById(projectId,userId);
        if(!project.getOwner().getId().equals(userId)){
            throw  new RuntimeException("Method Not Allowed");
        }
        User invite = userRepository.findByEmail(request.email()).orElseThrow();
        if(invite.getId().equals(userId)){
            throw  new RuntimeException("Cannot invite yourself");
        }

        ProjectMemberId projectMemberId= new ProjectMemberId(projectId,invite.getId());
        if(projectMemberRepository.existsById(projectMemberId)){
            throw new RuntimeException("Cannot invite it once");
        }
        ProjectMember member=ProjectMember.builder()
                .id(projectMemberId)
                .project(project)
                .user(invite)
                .projectRole(request.role())
                .invitedAt(Instant.now())
                .build();
        projectMemberRepository.save(member);
        return projectMemberMapper.toProjectMemberResponseFromMember(member);
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, updateMemberRoleRequest request, Long userId) {
        Project project= getAccessibleProjectById(projectId,userId);
        if(!project.getOwner().getId().equals(userId)){
            throw  new RuntimeException("Method Not Allowed");
        }
        ProjectMemberId projectMemberId= new ProjectMemberId(projectId,memberId);
        ProjectMember projectMember= projectMemberRepository.findById(projectMemberId).orElseThrow();
        projectMember.setProjectRole(request.role());
        projectMemberRepository.save(projectMember);

        return projectMemberMapper.toProjectMemberResponseFromMember(projectMember);
    }

    @Override
    public MemberResponse deleteMember(Long projectId, Long memberId, Long userId) {

        Project project = getAccessibleProjectById(projectId, userId);
        if (!project.getOwner().getId().equals(userId)) {
            throw new RuntimeException("Method Not Allowed");
        }
        ProjectMemberId projectMemberId =
                new ProjectMemberId(projectId, memberId);

        ProjectMember projectMember = projectMemberRepository
                .findById(projectMemberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        MemberResponse response =
                projectMemberMapper.toProjectMemberResponseFromMember(projectMember);

        projectMemberRepository.delete(projectMember);

        return response;
    }



    public Project getAccessibleProjectById(Long projectId, Long userId) {

        return projectRepository.findAccessibleProjectById(projectId, userId)
                .orElseThrow(() -> new RuntimeException("Project not found or access denied"));
    }
}