package vip.xiaozhao.intern.baseUtil.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vip.xiaozhao.intern.baseUtil.intf.dto.ResponseDO;
import vip.xiaozhao.intern.baseUtil.intf.service.UniversityService;

@RestController
@RequestMapping("/university")
@Slf4j
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    /**
     *
     * @param firstLetter
     * @return
     */
    @GetMapping("/listUniversityByFirstLetter")
    public ResponseDO listUniversityByFirstLetter(@RequestParam String firstLetter) {
        return ResponseDO.success(universityService.listUniversityByFirstLetter(firstLetter));
    }

    /**
     *
     * @param prefix
     * @return
     */
    @GetMapping("/listUniversityByPrefix")
    public ResponseDO listUniversityByPrefix(@RequestParam String prefix) {
        return ResponseDO.success(universityService.listUniversityByPrefix(prefix));
    }

    /**
     *
     * @param universityId
     * @return
     */
    @GetMapping("/listCollegeByUniversityId")
    public ResponseDO listCollegeByUniversityId(@RequestParam Integer universityId) {
        return ResponseDO.success(universityService.listCollegeByUniversityId(universityId));
    }

    /**
     *
     * @param firstLetter
     * @return
     */
    @GetMapping("/listMajorByFirstLetter")
    public ResponseDO listMajorByFirstLetter(@RequestParam String firstLetter) {
        return ResponseDO.success(universityService.listMajorByFirstLetter(firstLetter));
    }

    /**
     *
     * @param prefix
     * @return
     */
    @GetMapping("/listMajorByPrefix")
    public ResponseDO listMajorByPrefix(@RequestParam String prefix) {
        return ResponseDO.success(universityService.listMajorByPrefix(prefix));
    }
}
