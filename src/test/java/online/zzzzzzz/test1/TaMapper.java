package online.zzzzzzz.test1;

import java.util.List;

/**
 * @author zZZ.... <br/>
 * @description <br/>
 * @date 2023/12/29$  <br/>
 */
public interface TaMapper {


    Ta selectById(Integer id);

    List<Ta> selectAll();

    void insert(Ta ta);

    void update(Ta ta);

    void deleteById(Integer id);


}
