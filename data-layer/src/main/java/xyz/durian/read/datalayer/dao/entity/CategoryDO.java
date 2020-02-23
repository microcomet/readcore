package xyz.durian.read.datalayer.dao.entity;


import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 书籍分类
 *
 * @author fanwei
 * @version 1.0 28-9月-2018 0:24:47
 */
@Entity
@Table(name = "category")
public class CategoryDO {

    @Id
    @Column(nullable = false, length = 36)
    private String categoryId;
    @Column(length = 1000)
    private String description;
    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private LocalDateTime createTime;

    @Column
    private LocalDateTime updateTime;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

}