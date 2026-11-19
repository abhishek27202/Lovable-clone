package com.coding.lovable_clone.serviceImpl;

import com.coding.lovable_clone.dto.project.FileContentResponse;
import com.coding.lovable_clone.dto.project.FileNode;
import com.coding.lovable_clone.service.FileService;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public List<FileNode> getFile(Long id, Long userId) {
        return List.of();
    }

    @Override
    public @Nullable FileContentResponse getFileContent(Long projectId, String path, Long userid) {
        return null;
    }
}
