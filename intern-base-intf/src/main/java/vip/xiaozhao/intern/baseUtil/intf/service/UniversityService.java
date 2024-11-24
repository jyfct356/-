package vip.xiaozhao.intern.baseUtil.intf.service;

import vip.xiaozhao.intern.baseUtil.intf.dto.CollegeDO;
import vip.xiaozhao.intern.baseUtil.intf.dto.MajorDO;
import vip.xiaozhao.intern.baseUtil.intf.dto.UniversityDO;

import java.util.List;

public interface UniversityService {
    List<UniversityDO> listUniversityByFirstLetter(String firstLetter);

    List<UniversityDO> listUniversityByPrefix(String prefix);

    List<CollegeDO> listCollegeByUniversityId(Integer universityId);

    List<MajorDO> listMajorByFirstLetter(String firstLetter);

    List<MajorDO> listMajorByPrefix(String prefix);
}
