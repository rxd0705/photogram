package com.cos.photogramstart.domain.likes;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.domain.user.image.Image;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(
        uniqueConstraints = {@UniqueConstraint(
                name = "likes_uk",
                columnNames = {"imageId", "userId"}
        )
        }
)
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 번호증가 전략이 데이터베이스를 따라간다.
    private int id;

    @ManyToOne
    @JoinColumn(name = "imageId")
    private Image image;

    @JsonIgnoreProperties({"images"})
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    private LocalDateTime createDate;

    @PrePersist
    public void createDate() {
        this.createDate = LocalDateTime.now();
    }
}
