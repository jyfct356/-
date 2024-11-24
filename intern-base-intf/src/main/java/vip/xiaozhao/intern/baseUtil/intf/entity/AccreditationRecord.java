package vip.xiaozhao.intern.baseUtil.intf.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AccreditationRecord {
    /**
     * 入校时间
     */
    private LocalDate admissionTime;
    /**
     * 学院id
     */
    private long collegeId;
    /**
     * 学院名称
     */
    private String collegeName;
    /**
     * 学位类型
     */
    private long degreeType;
    /**
     * 审核不通过提示
     */
    private String description;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 离校时间
     */
    private LocalDate graduationTime;
    /**
     * 审核记录id
     */
    private long id;
    /**
     * 导师姓名
     */
    private String mentor;
    /**
     * 审核状态
     */
    private long status;
    /**
     * 学生证url
     */
    private String studentCardUrl;
    /**
     * 三级专业id
     */
    private long thirdMajorId;
    /**
     * 三级专业名称
     */
    private String thirdMajorName;
    /**
     * 二级专业名称
     */
    private String secondMajorName;
    /**
     * 学校id
     */
    private long universityId;
    /**
     * 学校名称
     */
    private String universityName;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户id
     */
    private long userId;
    /**
     * 认证使用验证码
     */
    private  String code;
    /**
     * 认证类型
     */
    private Integer type;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
}
