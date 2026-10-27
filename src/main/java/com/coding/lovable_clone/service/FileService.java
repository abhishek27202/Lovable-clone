package com.coding.lovable_clone.service;

import com.coding.lovable_clone.dto.project.FileContentResponse;
import com.coding.lovable_clone.dto.project.FileNode;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface FileService {

  List<FileNode> getFile(Long id, Long userId);

    @Nullable FileContentResponse getFileContent(Long projectId, String path, Long userid);
}


