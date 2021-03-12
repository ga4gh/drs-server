package org.ga4gh.drs.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import org.hibernate.Hibernate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "drs_object")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class DrsObject implements DrsEntity {
    
    /* COLUMN ATTRIBUTES LIFTED FROM DRS SPEC */

    @Id
    @Column(name = "id")
    @NonNull
    private String id;

    @Column(name = "description")
    private String description;

    // @NonNull
    @Column(name = "created_time")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime createdTime;

    @Column(name = "mime_type")
    private String mimeType;

    @Column(name = "name")
    private String name;

    @Column(name = "size")
    private long size;

    @Column(name = "updated_time")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime updatedTime;

    @Column(name = "version")
    private String version;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "drs_object_alias", joinColumns = @JoinColumn(name = "drs_object_id"))
    @Column(name = "alias")
    private List<String> aliases;

    /* COLUMN ATTRIBUTES, CUSTOM */

    /* Transient attributes */

    @Transient
    @NonNull
    private URI selfURI;

    @Transient
    // @NonNull
    private List<Checksum> checksums;

    @Transient
    private List<AccessMethod> accessMethods;

    @Transient
    private List<ContentsObject> contents;

    public DrsObject() {
        
    }

    public DrsObject(String id, URI selfURI, List<Checksum> checksums, LocalDateTime createdTime, long size) {
        this.setId(id);
        this.setSelfURI(selfURI);
        this.setChecksums(checksums);
        this.setCreatedTime(createdTime);
        this.setSize(size);
    }

    public void lazyLoad() {
        Hibernate.initialize(getAliases());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public URI getSelfURI() {
        return selfURI;
    }

    public void setSelfURI(URI selfURI) {
        this.selfURI = selfURI;
    }

    public List<Checksum> getChecksums() {
        return checksums;
    }

    public void setChecksums(List<Checksum> checksums) {
        this.checksums = checksums;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public List<AccessMethod> getAccessMethods() {
        return accessMethods;
    }

    public void setAccessMethods(List<AccessMethod> accessMethods) {
        this.accessMethods = accessMethods;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public List<ContentsObject> getContents() {
        return contents;
    }

    public void setContents(List<ContentsObject> contents) {
        this.contents = contents;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
