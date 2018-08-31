package com.example.domain.primary;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author: Yinpeng.Lin
 * @desc:
 * @date: Created in 2018/8/30 18:53
 */
@Component
public class UserDaoImpl implements UserDao {
    /*
     * 这里使用@Autowired无法区分primaryMongoTemplate和secondaryMongoTemplate
     * @Autowired优先按照类型匹配，若有多个匹配结果，则再按名称匹配，这里为何无法区分？
     */
   @Resource
   private MongoTemplate primaryMongoTemplate;

    /**
     * 如果不指定集合名，则默认为存储类型的名称
     * 这个例子若不指定集合名，则集合为userEntity
     */
   @Override
   public void saveUser(UserEntity userEntity) {
       primaryMongoTemplate.save(userEntity);
       // primaryMongoTemplate.save(userEntity, "users");
   }

   @Override
   public UserEntity findUserByUserName(String userName) {
       Query query = new Query(Criteria.where("userName").is(userName));
       return primaryMongoTemplate.findOne(query, UserEntity.class);
       // return primaryMongoTemplate.findOne(query, UserEntity.class, "users");
   }

   @Override
   public void updateUser(UserEntity user) {
       Query query = new Query(Criteria.where("id").is(user.getId()));
       Update update = new Update().set("userName", user.getUserName()).set("passWord", user.getPassword());
       //更新查询返回结果集的第一条
       primaryMongoTemplate.updateFirst(query, update, UserEntity.class);
       // primaryMongoTemplate.updateFirst(query, update, UserEntity.class, "users");
       //更新查询返回结果集的所有
       // primaryMongoTemplate.updateMulti(query,update,UserEntity.class);
   }

   @Override
   public void deleteUserById(Long id) {
       Query query = new Query(Criteria.where("id").is(id));
       primaryMongoTemplate.remove(query, UserEntity.class);
       // primaryMongoTemplate.remove(query, UserEntity.class, "users");
   }
}
