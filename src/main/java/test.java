import com.example.demo.dao.ShareDao;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Note;
import com.example.demo.mapper.DatabaseMapper;
import com.example.demo.model.ShareNote;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) throws IOException {
//        ShareDao.addShareNote(new ShareNote(2));

//        ShareNote a = new ShareNote(-1,"JabinGP",new Timestamp(System.currentTimeMillis()),"标题","内容",null,null);
//        ShareDao.addShareNote(a);

        for (int i = 0; i < ShareDao.getAllNotes().size(); i++) {
            System.out.println(ShareDao.getAllNotes().get(i));
        }
        ShareDao.removeShareNoteBySnId(6);
        for (int i = 0; i < ShareDao.getAllNotes().size(); i++) {
            System.out.println(ShareDao.getAllNotes().get(i));
        }
        //        // 根据 mybatis-config.xml 配置的信息得到 sqlSessionFactory
//        String resource = "config/mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        // 然后根据 sqlSessionFactory 得到 session
//        SqlSession session = sqlSessionFactory.openSession();
//        UserMapper myUser = session.getMapper(UserMapper.class);
//        if(mynote.isTableExist()>=1){
//            System.out.println("表已经存在，完成创建");
//        }else{
//            System.out.println("表不存在，现在开始创建表");
//            mynote.createTable();
//            System.out.println("表创建成功");
//        }
//       Map a = new HashMap();
//        a.put("u_name","Jabingp");
//        a.put("u_passwd","123456");

//        System.out.println(mynote.getPasswd("JabinGP"));
//        session.commit();
//        Note tmp = new Note("testFullUpdate",0,101,new Timestamp(System.currentTimeMillis()),"title--测试5.6.0中文显示","content--firsrkasdfjlkdjflksadjfsalkdfj","audio--12wqrwqerwerwerqw","picture--wqerwqrqwerwqerwqerweqrerqw",new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()));
//        mynote.addData(tmp);
//        session.commit();

//        Note tmp = new Note("testFullUpdate",0,101,new Timestamp(System.currentTimeMillis()),"测试完全更新","测试完全更新","测试完全更新","测试完全更新",new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()));
//        mynote.delDataById(1);
//        session.commit();
    }

}
//addData
//searchDataByIds
//searchDataById
//fullUpdateData
//setEdShareTimeByIds
//setBgShareTimeByIds
//setPicturePathByIds
//setAudioPathByIds
//setTimesByIds
//setContentByIds
//setTitleByIds
//delDataByIds