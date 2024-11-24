package vip.xiaozhao.intern.baseUtil.intf.mapper;

import org.apache.ibatis.annotations.*;
import vip.xiaozhao.intern.baseUtil.intf.dto.AccreditationDO;
import vip.xiaozhao.intern.baseUtil.intf.entity.AccreditationRecord;

import java.util.List;

@Mapper
public interface AccreditationMapper {

    @Insert("insert into AccreditationRecord(userId, userName, universityId, universityName, collegeId, collegeName, " +
            "thirdMajorId, thirdMajorName, secondMajorName, degreeType, mentor, email, type, code, studentCardUrl, " +
            "admissionTime, graduationTime, status, createTime, updateTime) " +
            "value(#{userId}, #{userName}, #{universityId}, #{universityName}, #{collegeId}, #{collegeName}, " +
            "#{thirdMajorId}, #{thirdMajorName}, #{secondMajorName}, #{degreeType}, #{mentor}, #{email}, #{type}, #{code}, #{studentCardUrl}, " +
            "#{admissionTime}, #{graduationTime}, #{status}, #{createTime}, #{updateTime})")
    @Options(useGeneratedKeys = true)
    Long insertAccreditationRecord(AccreditationRecord accreditationRecord);

    @Select("select * from AccreditationRecord where userId = #{userId} order by createTime desc")
    List<AccreditationRecord> getAccreditationRecordsByUserIdDesCreateTime(Long userId);

    @Update("update AccreditationRecord set universityId = #{universityId}, " +
            "universityName = #{universityName}, collegeId = #{collegeId}, collegeName = #{collegeName}, " +
            "thirdMajorId = #{thirdMajorId}, thirdMajorName = #{thirdMajorName}, secondMajorName = #{secondMajorName}, " +
            "degreeType = #{degreeType}, mentor = #{mentor}, email = #{email}, type = #{type}, code = #{code}, studentCardUrl = #{studentCardUrl}, " +
            "admissionTime = #{admissionTime}, graduationTime = #{graduationTime}, status = #{status}, updateTime = #{updateTime} " +
            "where id = #{id}")
    void updateAccreditationRecord(AccreditationRecord accreditationRecord);

    @Update("update AccreditationRecord set status = ${@vip.xiaozhao.intern.baseUtil.intf.constant.AccreditationConstant@CANCELLED} where id = #{id}")
    void deleteAccreditationRecord(Integer id);

    @Select("select * from AccreditationRecord where userId = #{userId} and status = ${@vip.xiaozhao.intern.baseUtil.intf.constant.AccreditationConstant@PENDING}")
    AccreditationRecord getPendingAccreditationRecordsByUserId(Long userId);
}