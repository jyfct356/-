package vip.xiaozhao.intern.baseUtil.intf.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import vip.xiaozhao.intern.baseUtil.intf.dto.CollegeDO;
import vip.xiaozhao.intern.baseUtil.intf.dto.MajorDO;
import vip.xiaozhao.intern.baseUtil.intf.dto.UniversityDO;

import java.util.List;

@Mapper
public interface UniversityMapper {

    @Select("select id, name from University where firstLetter = #{firstLetter}")
    List<UniversityDO> listUniversityByFirstLetter(String firstLetter);

    @Select("select id, name from University where name like concat(#{firstLetter}, '%')")
    List<UniversityDO> listUniversityByPrefix(String prefix);

    @Select("select id, name from College where universityId = #{universityId}")
    List<CollegeDO> listCollegeByUniversityId(Integer universityId);

    @Select("select id, name, secondMajorName from MajorThird where firstLetter = #{firstLetter}")
    List<MajorDO> listMajorByFirstLetter(String firstLetter);

    @Select("select id, name, secondMajorName from MajorThird where name like concat(#{firstLetter}, '%')")
    List<MajorDO> listMajorByPrefix(String prefix);
}
