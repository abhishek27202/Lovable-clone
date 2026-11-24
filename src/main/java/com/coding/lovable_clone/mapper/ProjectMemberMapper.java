package com.coding.lovable_clone.mapper;

import com.coding.lovable_clone.dto.Member.MemberResponse;

import com.coding.lovable_clone.entity.ProjectMember;
import com.coding.lovable_clone.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMemberMapper {

    @Mapping(target = "userId", source = "id")
    @Mapping(target= "role", constant = "OWNER")
    MemberResponse toProjectMemberResponseFromOwner(User owner);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "email", source = "user.email")
    @Mapping(target = "name", source = "user.name")
    @Mapping(target = "role", source = "projectRole")
   // @Mapping(target = "InvitedAt", source = "invitedAt")
    //@Mapping(target= "role", constant = "EDITOR")

    MemberResponse toProjectMemberResponseFromMember(ProjectMember projectMember);
}
