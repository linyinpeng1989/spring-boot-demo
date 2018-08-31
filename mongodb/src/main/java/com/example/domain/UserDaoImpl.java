package com.example.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

/**
 * @author: Yinpeng.Lin
 * @desc:
 * @date: Created in 2018/8/30 18:53
 */
@Component
public class UserDaoImpl implements UserDao {
   @Autowired
   private MongoTemplate mongoTemplate;

    /**
     * 如果不指定集合名，则默认为存储类型的名称
     * 这个例子若不指定集合名，则集合为userEntity
     */
   @Override
   public void saveUser(UserEntity userEntity) {
       mongoTemplate.save(userEntity);
       // mongoTemplate.save(userEntity, "users");
   }

   @Override
   public UserEntity findUserByUserName(String userName) {
       Query query = new Query(Criteria.where("userName").is(userName));
       return mongoTemplate.findOne(query, UserEntity.class);
       // return mongoTemplate.findOne(query, UserEntity.class, "users");
   }

   @Override
   public void updateUser(UserEntity user) {
       Query query = new Query(Criteria.where("id").is(user.getId()));
       Update update = new Update().set("userName", user.getUserName()).set("passWord", user.getPassword());
       //更新查询返回结果集的第一条
       mongoTemplate.updateFirst(query, update, UserEntity.class);
       // mongoTemplate.updateFirst(query, update, UserEntity.class, "users");
       //更新查询返回结果集的所有
       // mongoTemplate.updateMulti(query,update,UserEntity.class);
   }

   @Override
   public void deleteUserById(Long id) {
       Query query = new Query(Criteria.where("id").is(id));
       mongoTemplate.remove(query, UserEntity.class);
       // mongoTemplate.remove(query, UserEntity.class, "users");
   }
}
