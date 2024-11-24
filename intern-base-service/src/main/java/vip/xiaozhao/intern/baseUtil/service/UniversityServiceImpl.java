package vip.xiaozhao.intern.baseUtil.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.xiaozhao.intern.baseUtil.intf.dto.CollegeDO;
import vip.xiaozhao.intern.baseUtil.intf.dto.MajorDO;
import vip.xiaozhao.intern.baseUtil.intf.dto.UniversityDO;
import vip.xiaozhao.intern.baseUtil.intf.mapper.UniversityMapper;
import vip.xiaozhao.intern.baseUtil.intf.service.UniversityService;

import java.util.List;

@Service
@Slf4j
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    private UniversityMapper universityMapper;

    @Override
    public List<UniversityDO> listUniversityByFirstLetter(String firstLetter) {
        return universityMapper.listUniversityByFirstLetter(firstLetter);
    }

    @Override
    public List<UniversityDO> listUniversityByPrefix(String prefix) {
        return universityMapper.listUniversityByPrefix(prefix);
    }

    @Override
    public List<CollegeDO> listCollegeByUniversityId(Integer universityId) {
        return universityMapper.listCollegeByUniversityId(universityId);
    }

    @Override
    public List<MajorDO> listMajorByFirstLetter(String firstLetter) {
        return universityMapper.listMajorByFirstLetter(firstLetter);
    }

    @Override
    public List<MajorDO> listMajorByPrefix(String prefix) {
        return universityMapper.listMajorByPrefix(prefix);
    }
}
