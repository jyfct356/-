package vip.xiaozhao.intern.baseUtil.service;

import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;

import vip.xiaozhao.intern.baseUtil.intf.constant.ResourcesConstant;
import vip.xiaozhao.intern.baseUtil.intf.dto.AccreditationInfoDO;
import vip.xiaozhao.intern.baseUtil.intf.service.FileService;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Slf4j
public class FileServiceImpl implements FileService {

    @Value("${home.url}")
    private String url;

    @Value("${server.port}")
    private String port;

    /**
     * 上传图片，返回url
     * @param userId
     * @param accreditationInfoDO
     * @return
     */
    @Override
    public String uploadStudentCard(Long userId, AccreditationInfoDO accreditationInfoDO) {
        // 切分Base64头和内容
        String imgStr = accreditationInfoDO.getImageStudentCardStr();
        String imgHead = imgStr.substring(0, imgStr.indexOf(",") + 1);
        String imgContent = imgStr.substring(imgStr.indexOf(",", 1) + 1);

        // 将Base64字符串内容转为图片
        byte[] imgBytes = Base64.decodeBase64(imgContent);
        for (int i = 0; i < imgBytes.length; ++i) {
            if (imgBytes[i] < 0) {
                imgBytes[i] += (byte) 256;
            }
        }

        // 构建文件资源路径并写入
        String imageSuffix = "." + imgHead.substring(imgHead.indexOf("/") + 1, imgHead.indexOf(";"));
        String imgFileName = userId + "-" + System.currentTimeMillis() + "-" + UUID.randomUUID() + imageSuffix;
        String imgPath = ResourcesConstant.IMAGEDIR + imgFileName;
        try (FileOutputStream fos = new FileOutputStream(imgPath)) {
            fos.write(imgBytes);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 返回url
        return url + ":" + port + ResourcesConstant.IMAGEPATHPREFIX + imgFileName;
    }
}
