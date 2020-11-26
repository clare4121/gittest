package com.cyp.gitnewmodulewhole.util;




import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Map;

/**
 * 数据库查询DAO，封装了基本的查询方法，包括增删改查分页查等。
 * 使用此类时，使用@Resource注解注入。
 * @author qxl
 * @date 2017年1月10日 上午10:23:07
 * @version 1.0.0
 */

@Component
public class DaoHelper {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    /**
     * 根据条件删除记录
     * @param _mybitsId
     * @param obj
     * @return
     */
    public <T> int delete(String _mybitsId, T obj) {
        return sqlSessionTemplate.delete(_mybitsId, obj);
    }


    /**
     * 将指定的对象插入到数据库
     * @param _mybitsId
     * @param obj
     * @return
     */
    public <T> int insert(String _mybitsId, T obj) {
        return sqlSessionTemplate.insert(_mybitsId, obj);
    }

    /**
     * 更新
     * @param _mybitsId
     * @param obj
     * @return
     */
    public <T> int update(String _mybitsId, T obj) {
        return sqlSessionTemplate.update(_mybitsId, obj);
    }

    /**
     * 无条件查询结果集，返回List<T>
     * @param _mybitsId
     * @return
     */
    public <T> List<T> queryForList(String _mybitsId) {
        return sqlSessionTemplate.selectList(_mybitsId);
    }

    /**
     * 查询结果集，查询参数为Map，返回List<T>
     * @param _mybitsId
     * @param _params
     * @return
     */
    public <T> List<T> queryForList(String _mybitsId, Map<String, Object> _params) {
        return sqlSessionTemplate.selectList(_mybitsId, _params);
    }

    /**
     * 查询结果集，查询参数为Object，返回List<T>
     * @param _mybitsId
     * @param _params
     * @return
     */
    public <T> List<T> queryForList(String _mybitsId, Object _params) {
        return sqlSessionTemplate.selectList(_mybitsId, _params);
    }




    /**
     * 查询一条记录
     * @param _mybitsId
     * @param object
     * @return
     */
    public Object queryOne(String _mybitsId, Object object) {
        return sqlSessionTemplate.selectOne(_mybitsId, object);
    }
}
