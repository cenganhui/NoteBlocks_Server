package com.example.demo.api;

import com.example.demo.dao.DbDao;
import com.example.demo.dao.NoteDao;
import com.example.demo.dao.ShareDao;
import com.example.demo.dao.UserDao;
import com.example.demo.model.Note;
import com.example.demo.model.User;
import com.example.demo.model.ShareNote;
import com.example.demo.utils.DealHtml;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;

/**
 * API导航类
 */
@RestController
public class API {
    public static String fileRootPath = "/home/www/noteblocks";
    public static String fileUrl = "http://47.115.148.227:8202/noteblocks";

    public API() {
    }

    /**
     * 下载文件
     *
     * @param filename 下载文件名
     * @param response
     * @return
     */
    @GetMapping(value = "/downloadFile")
    public StreamingResponseBody downloadFile(String filename, HttpServletResponse response) {
        String filePath = fileRootPath + filename;
        if (new File(filePath).exists()) {
            response.setContentType("application/text");//设置响应头，保证数据能够以文件形式接收
            response.setHeader("Content-Disposition", "attachment;filename=\"" + filename + "\"");//设置下载文件名

            try {
                final InputStream is = new FileInputStream(filePath);

                return outputStream -> {
                    int nRead;
                    byte[] data = new byte[1024];
                    while ((nRead = is.read(data, 0, data.length)) != -1) {
                        outputStream.write(data, 0, nRead);
                    }
                    outputStream.flush();
                    outputStream.close();
                    System.out.println("downloadFile -- " + filename);
                };
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    /**
     * 传入带账号密码的json，返回比对结果
     *
     * @param cmpUser
     * @return
     */
    @PostMapping("/comparPasswd")
    public String comparPasswd(@RequestBody User cmpUser) {
        System.out.println("comparPasswd -- " + "u_name:" + cmpUser.getU_name() + ",u_passwd:" + cmpUser.getU_passwd());
        return "comparPasswd:" + UserDao.comparPasswd(cmpUser.getU_name(), cmpUser.getU_passwd());
    }

    /**
     * 传入创建用户的Json，返回创建结果
     *
     * @param newUser
     * @return
     */
    @PostMapping("/createUser")
    public String createUser(@RequestBody User newUser) {
        System.out.println("addUser -- " + "u_name:" + newUser.getU_name() + ",u_passwd:" + newUser.getU_passwd());
        return "createUser:" + UserDao.createNewUser(newUser.getU_name(), newUser.getU_passwd());
    }

    /**
     * 传入json，更改密码
     *
     * @param newPasswdUser
     * @return
     */
    @PostMapping("/changePasswd")
    public String changePasswd(@RequestBody User newPasswdUser) {
        System.out.println("changePasswd -- " + "name:" + newPasswdUser.getU_name() + ",newPasswd:" + newPasswdUser.getU_passwd());
        return "changePasswd:" + UserDao.changePasswd(newPasswdUser.getU_name(), newPasswdUser.getU_passwd());
    }


    /**
     * 传入json数组，把便签全部备份到数据库中
     *
     * @param uploadNotes
     * @return
     */
    @PostMapping("/backupNotes")
    public String backupNotes(@RequestBody ArrayList<Note> uploadNotes) {
        System.out.println("backupNotes -- ");

        NoteDao.reloadNotes(uploadNotes.get(0).getU_name());
        for (int i = 0; i < uploadNotes.size(); i++) {
            System.out.println(uploadNotes.get(i));
            NoteDao.addNote(uploadNotes.get(i));
        }
        return "backupNotes:" + true;
    }

    /**
     * 通过用户名获取数据库所有该用户的便签
     *
     * @param u_name
     * @return
     */
    @GetMapping("/downNotes")
    public ArrayList getNotes(String u_name) {
        NoteDao.reloadNotes(u_name);
        return NoteDao.getAllNotes();
    }


    /**
     * 传入一个json，将该便签放在分享区，供另一个接口调用
     *
     * @param shareNote
     * @return
     */
    @PostMapping("/shareNote")
    public String shareNote(@RequestBody ShareNote shareNote) {
        System.out.println("shareNote -- ");
        return "shareNote:" + ShareDao.addShareNote(shareNote);
    }

    /**
     * 分享便签后，调用该接口获取对应的界面
     *
     * @param sn_id
     * @return
     */
    @GetMapping("/getShareNote")
    public String getShareNote(int sn_id) {
        ShareDao.reloadNotes();
        ShareNote shareNote = ShareDao.getShareNoteBySnId(sn_id);
        return DealHtml.putNoteInHtml(shareNote);
    }

    /**
     * 单文件上传
     *
     * @param multipartFile
     * @return
     */
    @PostMapping("/uploadSingleFile")
    public String uploadSingleFile(@RequestParam MultipartFile multipartFile) {
        System.out.println("进入上传单文件接口");
        if (multipartFile.isEmpty()) {
            return "uploadSingleFile:" + "上传失败，请选择文件";
        }
        String fileName = multipartFile.getOriginalFilename();
        File dest = new File(fileRootPath + fileName);
        try {
            multipartFile.transferTo(dest);
            return "uploadSingleFile:" + "上传成功";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "uploadSingleFile:" + "上传失败！";

    }

    /**
     * 多文件上传
     *
     * @param multipartFile
     * @return
     */
    @PostMapping("/uploadFiles")
    public String uploadFiles(@RequestParam MultipartFile multipartFile[]) {
        System.out.println("进入上传多文件接口");
        boolean success = true;
        for (MultipartFile singleFile : multipartFile) {
            if (singleFile.isEmpty()) {
                success = false;
                System.out.println("uploadFiles--循环内：文件为空，上传失败！");
            } else {
                String fileName = singleFile.getOriginalFilename();
                File dest = new File(fileRootPath + fileName);
                try {
                    singleFile.transferTo(dest);
                    System.out.println("uploadFiles--循环内：上传成功！");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "uploadFiles:" + success;

    }

}
