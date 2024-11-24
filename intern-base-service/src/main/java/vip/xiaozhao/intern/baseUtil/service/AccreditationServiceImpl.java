package vip.xiaozhao.intern.baseUtil.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.xiaozhao.intern.baseUtil.intf.constant.AccreditationConstant;
import vip.xiaozhao.intern.baseUtil.intf.dto.AccreditationDO;
import vip.xiaozhao.intern.baseUtil.intf.entity.AccreditationRecord;
import vip.xiaozhao.intern.baseUtil.intf.mapper.AccreditationMapper;
import vip.xiaozhao.intern.baseUtil.intf.mapper.UniversityMapper;
import vip.xiaozhao.intern.baseUtil.intf.service.AccreditationService;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class AccreditationServiceImpl implements AccreditationService {

    @Autowired
    private AccreditationMapper accreditationMapper;
    @Autowired
    private UniversityMapper universityMapper;

    /**
     * 插入一条审核记录
     * @param userId
     * @param accreditationDO
     * @return
     */
    @Override
    public Long insertAccreditationRecord(Long userId, AccreditationDO accreditationDO) {
        // 数据校验
        if (accreditationDO == null) {
            log.error("accreditationDO is null");
            return null;
        }
        if (accreditationDO.getType().equals(AccreditationConstant.TYPE_EMAIL)
                && (accreditationDO.getEmail() == null || accreditationDO.getCode() == null)) {
            log.error("using email type without email or code");
            return null;
        }
        if (accreditationDO.getType().equals(AccreditationConstant.TYPE_STUDENT_CARD)
                && accreditationDO.getStudentCardUrl() == null) {
            log.error("using student card while url is null");
            return null;
        }
        AccreditationRecord record = accreditationMapper.getPendingAccreditationRecordsByUserId(userId);
        if (record != null) {
            log.error("同一用户同时只能有一条审核中的记录");
            return null;
        }


        // copy实体对象Record
        AccreditationRecord accreditationRecord = new AccreditationRecord();
        BeanUtils.copyProperties(accreditationDO, accreditationRecord);
        // 用户信息
        accreditationRecord.setUserId(userId);
        accreditationRecord.setUserName("临时用户");

        // 设置状态，审核中
        accreditationRecord.setStatus(AccreditationConstant.PENDING);

        // 时间字段填充
        LocalDateTime now = LocalDateTime.now();
        accreditationRecord.setCreateTime(now);
        accreditationRecord.setUpdateTime(now);
        return accreditationMapper.insertAccreditationRecord(accreditationRecord);
    }

    /**
     * 查询审核记录
     * @param userId
     * @return
     */
    @Override
    public AccreditationDO getAccreditationRecordByUserId(Long userId) {
        // 按创建时间从近到远 查询审核记录列表
        List<AccreditationRecord> accreditationRecordList = accreditationMapper.getAccreditationRecordsByUserIdDesCreateTime(userId);
        if (accreditationRecordList == null || accreditationRecordList.isEmpty()) {
            return null;
        }
        // 取最近的一条
        AccreditationRecord accreditationRecord = accreditationRecordList.get(0);
        AccreditationDO accreditationDO = new AccreditationDO();
        BeanUtils.copyProperties(accreditationRecord, accreditationDO);

        // 根据学校id查询校徽url
        accreditationDO.setBadgeUrl("校徽的Url，其他服务会补上");

        return accreditationDO;
    }

    /**
     * 更新审核记录
     * @param accreditationDO
     */
    @Override
    public void updateAccreditationRecord(AccreditationDO accreditationDO) {
        // 数据校验
        if (accreditationDO == null) {
            log.error("accreditationDO is null");
            return ;
        }
        if (accreditationDO.getType().equals(AccreditationConstant.TYPE_EMAIL)
                && (accreditationDO.getEmail() == null || accreditationDO.getCode() == null)) {
            log.error("using email type without email or code");
            return ;
        }
        if (accreditationDO.getType().equals(AccreditationConstant.TYPE_STUDENT_CARD)
                && accreditationDO.getStudentCardUrl() == null) {
            log.error("using student card while url is null");
            return ;
        }

        // copy Record
        AccreditationRecord accreditationRecord = new AccreditationRecord();
        BeanUtils.copyProperties(accreditationDO, accreditationRecord);

        // 更新时间填充
        LocalDateTime now = LocalDateTime.now();
        accreditationRecord.setUpdateTime(now);
        accreditationMapper.updateAccreditationRecord(accreditationRecord);
    }

    /**
     * 逻辑删除
     * @param id
     */
    @Override
    public void deleteAccreditationRecord(Integer id) {
        accreditationMapper.deleteAccreditationRecord(id);
    }
}
