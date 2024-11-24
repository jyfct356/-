package vip.xiaozhao.intern.baseUtil.intf.service;

import vip.xiaozhao.intern.baseUtil.intf.dto.AccreditationInfoDO;

public interface FileService {

    String uploadStudentCard(Long userId, AccreditationInfoDO accreditationInfoDO);
}
