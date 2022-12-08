package com.itis.servletsapp.model;

import lombok.*;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private Long id;
    private String title;
    private String text;
    private byte[] img;
    private String imgName;
    private Long userID;
}
