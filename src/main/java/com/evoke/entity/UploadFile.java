package com.evoke.entity;

import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UploadFile {

    @Id
    @GeneratedValue
    private Long id;

    private String filename;

    private String mimeType;

    private String url;

    private String thumbnailUrl;

    private Boolean active;

    private String originalFilename;

    private Long filesize;

    private Integer orientation;


}
