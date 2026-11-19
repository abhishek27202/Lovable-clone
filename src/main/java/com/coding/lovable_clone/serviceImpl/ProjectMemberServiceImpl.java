package com.coding.lovable_clone.serviceImpl;

import com.coding.lovable_clone.dto.Member.InviteMemberRequest;
import com.coding.lovable_clone.dto.Member.MemberResponse;
import com.coding.lovable_clone.dto.Member.updateMemberRoleRequest;
import com.coding.lovable_clone.service.ProjectMemberService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectMemberServiceImpl implements ProjectMemberService {
    @Override
    public List<MemberResponse> getProjectMember(Long projectId, Long userId) {
        return List.of();
    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {
        return null;
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, updateMemberRoleRequest request, Long userId) {
        return null;
    }

    @Override
    public MemberResponse deleteMember(Long projectId, Long memberId, Long userId) {
        return null;
    }
}
