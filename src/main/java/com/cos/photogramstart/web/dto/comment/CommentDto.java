package com.cos.photogramstart.web.dto.comment;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CommentDto {
    @NotBlank
    private String content;
    @NotNull
    private Integer imageId;
}
