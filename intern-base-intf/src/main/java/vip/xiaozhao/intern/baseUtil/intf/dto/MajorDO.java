package vip.xiaozhao.intern.baseUtil.intf.dto;

import lombok.Data;

@Data
public class MajorDO {
    /**
     * 三级专业id
     */
    private long id;
    /**
     * 三级专业名称
     */
    private String name;
    /**
     * 二级专业名称
     */
    private String secondMajorName;
}
