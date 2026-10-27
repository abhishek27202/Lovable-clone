package com.coding.lovable_clone.service;

import com.coding.lovable_clone.dto.Member.InviteMemberRequest;
import com.coding.lovable_clone.dto.Member.MemberResponse;
import com.coding.lovable_clone.entity.ProjectMember;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface ProjectMemberService {

    List<ProjectMember> getProjectMember(Long projectId, Long userId);

    MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId);

     MemberResponse updateMemberRole(Long projectId, Long memberId, InviteMemberRequest request,Long userId);

     MemberResponse deleteMember(Long projectId, Long memberId, Long userId);
}
