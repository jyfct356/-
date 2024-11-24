package vip.xiaozhao.intern.baseUtil.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vip.xiaozhao.intern.baseUtil.intf.constant.CommonConstant;
import vip.xiaozhao.intern.baseUtil.intf.dto.AccreditationInfoDO;
import vip.xiaozhao.intern.baseUtil.intf.dto.ResponseDO;
import vip.xiaozhao.intern.baseUtil.intf.service.FileService;

@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {

    @Autowired
    private FileService fileService;

    /**
     * 上传认证附件
     * @param accreditationInfoDO
     * @return
     */
    @PostMapping("/accreditation/upload")
    public ResponseDO uploadAccreditationInfo(HttpServletRequest httpServletRequest,
                                              @RequestBody AccreditationInfoDO accreditationInfoDO) {
        Long userId = (Long) httpServletRequest.getAttribute(CommonConstant.LOGIN_USERID_KEY);
        return ResponseDO.success(fileService.uploadStudentCard(userId, accreditationInfoDO));
    }
}
