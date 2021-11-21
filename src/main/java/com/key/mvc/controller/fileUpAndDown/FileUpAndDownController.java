package com.key.mvc.controller.fileUpAndDown;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * 测试文件上传和下载控制器
 *
 * @author Key
 * @date 2021/10/19/14:32
 **/
@Controller
public class FileUpAndDownController {

    /**
     * 文件上传
     */
    @RequestMapping("/fileUpload")
    public String fileUpload(MultipartFile uploadFile, HttpSession session) throws IOException {
        // 1. 先获取上传的文件名
        String filename = uploadFile.getOriginalFilename();
        System.out.println("上传文件名 --> " + filename);

        // 2.1 获取文件的后缀名（文件名不为null和空情况下）
        String suffixName = "";
        if (filename != null && ! "".equals(filename)) {
            // 截取字符串，获取字符串后面的后缀名
            suffixName = filename.substring(filename.lastIndexOf("."));
        }
        // 2.2 通过UUID随机生成一个字符串，与后缀名拼接替换原来的文件名，防止文件名冲突
        filename = UUID.randomUUID().toString().replace("-", "") + suffixName;

        // 3. 通过session获取servletContext对象，并获取工程下的photo目录的路径
        String dirPath = session.getServletContext().getRealPath("/photo");

        // 4. 根据获取的photo目录路径创建File对象，再判断该目录是否存在，如果不存在就创建
        File file = new File(dirPath);
        if (! file.exists()) {
            // 如果不存在就创建对应目录
            boolean mkdir = file.mkdir();
        }

        // 5.1 设置文件上传的位置
         String finalPath = dirPath + File.separator + filename;

        // 设置固定的上传路径
//        String finalPath =
//                "D:\\ideaProject\\practice_ssm\\SpringMVCLearn\\src\\main\\webapp\\static\\image\\" +
//                        filename;

        // 5.2 根据上传路径创建出对应的File对象
        File finalPathFile = new File(finalPath);

        // 6. 调用MultipartFile对象的transferTo()方法，将上传的文件写到对应的位置
        uploadFile.transferTo(finalPathFile);

        return "success";
    }

    /**
     * 文件下载
     */
    @RequestMapping("/fileDownload")
    public ResponseEntity<byte[]> fileDownload(String filename, HttpSession session) throws IOException {
        // 1. 获取请求参数——文件名filename
        System.out.println("文件名 -->" + filename);

        // 2.1 获取servletContext对象
        ServletContext servletContext = session.getServletContext();
        // 2.2 通过servletContext对象获取文件资源并转化为输入流
        InputStream fileIn = servletContext.getResourceAsStream("/static/image/code.png");

        // 3. 创建字节数据，并将文件流读取字节数据中（fileIn.available()为输入流的全部字节数）
        byte[] bytes = new byte[fileIn.available()];
        fileIn.read(bytes);

        // 4.1 创建请求头对象
        MultiValueMap<String, String> headers = new HttpHeaders();
        // 4.1 通过请求头设置请求头信息
        headers.add("Content-Disposition", "attachment;filename=" +
                URLEncoder.encode(filename, "utf-8"));

        // 5. 创建响应状态码对象并设置响应状态为OK
        HttpStatus status = HttpStatus.OK;

        // 6. 创建responseEntity对象，并传入文件字节数据（响应体信息）、响应头对象、响应状态码对象
        ResponseEntity<byte[]> respEntity = new ResponseEntity<>(bytes, headers, status);

        // 7. 关闭资源
        fileIn.close();

        System.out.println("文件下载成功！");

        return respEntity;
    }
}
