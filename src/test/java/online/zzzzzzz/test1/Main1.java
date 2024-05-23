package online.zzzzzzz.test1;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * @author zZZ.... <br/>
 * @description <br/>
 * @date 2023/12/29$  <br/>
 */
public class Main1 {

  public static void main(String[] args) throws IOException {
    //把核心配置文件读入流中
    //这里就是在五个常用的类加载器的类路径下查找指定的xml
    InputStream stream = Resources.getResourceAsStream("online.zzzzzzz.test1/mybatis-config.xml");

    //创建一个session工厂的构建者
    SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
    // 创建SqlSession的工厂
    //这里会构建一个默认的SqlSessionFactory，解析了配置类
    SqlSessionFactory factory = sqlSessionFactoryBuilder.build(stream);
    /*
    * 创建SqlSession对象
    *   每个sqlSession对象里会创建‘事务对象’，‘执行器对象’
    *   执行器对象才是真正执行sql的对象
    *
    * */
    SqlSession session = factory.openSession();
    // 第一个为statement的Id，第二个parameter的参数
    Ta ta = session.selectOne("TaMapper.getUserById", "70708");
    HashMap<String, Object> map = new HashMap<>();
    session.update("update",map);
    Ta ta1 = session.selectOne("TaMapper.getUserById1", "70708");
    session.close();
    System.out.println(ta);
    // 释放资源
    session.close();
  }
}
