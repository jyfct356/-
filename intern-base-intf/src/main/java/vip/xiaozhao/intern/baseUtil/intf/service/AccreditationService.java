package vip.xiaozhao.intern.baseUtil.intf.service;

import vip.xiaozhao.intern.baseUtil.intf.dto.AccreditationDO;

public interface AccreditationService {
    Long insertAccreditationRecord(Long userId, AccreditationDO accreditationDO);

    AccreditationDO getAccreditationRecordByUserId(Long userId);

    void updateAccreditationRecord(AccreditationDO accreditationDO);

    void deleteAccreditationRecord(Integer id);
}
