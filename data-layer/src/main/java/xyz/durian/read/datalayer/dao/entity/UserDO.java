package xyz.durian.read.datalayer.dao.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "user")
public class UserDO {

    /**
     * UUID
     */
    @Id
    @Column(nullable = false, length = 36)
    private String userId;
    /**
     * 用户名
     */
    @Column(nullable = false, length = 50)
    private String userName;

    /**
     * 用户类型
     */
    @Column(nullable = false, length = 10)
    private String type;

    /**
     * 用户的密码
     */
    @Column(nullable = false, length = 100)
    private String password;

    /**
     * 用户简介
     */
    @Column(length = 200)
    private String profile;

    /**
     * 出生日期
     */
    @Column
    private LocalDate birthday;

    /**
     * 手机号
     */
    @Column
    private String mobilePhone;

    /**
     * 邮箱
     */
    @Column
    private String email;

    /**
     * 创建用户的时间
     */
    @Column(nullable = false)
    private LocalDateTime createTime;

    /**
     * 更新用户的时间
     */
    @Column
    private LocalDateTime updateTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
