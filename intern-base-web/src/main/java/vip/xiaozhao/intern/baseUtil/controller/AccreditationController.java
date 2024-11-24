package vip.xiaozhao.intern.baseUtil.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vip.xiaozhao.intern.baseUtil.intf.constant.CommonConstant;
import vip.xiaozhao.intern.baseUtil.intf.dto.AccreditationDO;
import vip.xiaozhao.intern.baseUtil.intf.dto.ResponseDO;
import vip.xiaozhao.intern.baseUtil.intf.service.AccreditationService;

@RestController
@RequestMapping("/accreditation")
@Slf4j
public class AccreditationController {

    @Autowired
    private AccreditationService accreditationService;

    /**
     * 提交认证
     * @param accreditationDO
     * @param request
     * @return
     */
    @PostMapping("/submit")
    public ResponseDO submit(HttpServletRequest request,
            @RequestBody AccreditationDO accreditationDO) {
        Long userId = (Long) request.getAttribute(CommonConstant.LOGIN_USERID_KEY);
        return ResponseDO.success(accreditationService.insertAccreditationRecord(userId, accreditationDO));
    }

    /**
     * 查找当前用户的审核记录
     * @return
     */
    @GetMapping("/getByUserId")
    public ResponseDO getByUserId(HttpServletRequest request) {
        Long userId = (Long) request.getAttribute(CommonConstant.LOGIN_USERID_KEY);
        return ResponseDO.success(accreditationService.getAccreditationRecordByUserId(userId));
    }

    /**
     * 更新审核记录
     * @param accreditationDO
     * @return
     */
    @PostMapping("/update")
    public ResponseDO update(@RequestBody AccreditationDO accreditationDO) {
        accreditationService.updateAccreditationRecord(accreditationDO);
        return ResponseDO.success();
    }

    /**
     * 根据审核记录id删除
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseDO delete(@PathVariable Integer id) {
        accreditationService.deleteAccreditationRecord(id);
        return ResponseDO.success();
    }


}
