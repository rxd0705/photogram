package com.cos.photogramstart.web.dto.image;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.domain.user.image.Image;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ImageUploadDto {
    private MultipartFile file;
    private String caption;

    public Image toEntity(String postImageUrl, User user) {
        return Image.builder()
                .caption(caption)
                .postImageUrl(postImageUrl)
                .user(user)
                .build();
    }
}
