//package com.example.demo.common.mongo;
//
//import com.example.demo.domain.UserEntity;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.data.mongodb.core.query.Update;
//import org.springframework.stereotype.Component;
//
///**
// * Created by linyp on 2017/8/10.
// * MongoDB相关
// */
//@Component
//public class UserDaoImpl implements UserDao {
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    @Override
//    public void saveUser(UserEntity userEntity) {
//        mongoTemplate.save(userEntity);
//    }
//
//    @Override
//    public UserEntity findUserByUserName(String userName) {
//        Query query = new Query(Criteria.where("userName").is(userName));
//        return mongoTemplate.findOne(query, UserEntity.class);
//    }
//
//    @Override
//    public void updateUser(UserEntity user) {
//        Query query = new Query(Criteria.where("id").is(user.getId()));
//        Update update = new Update().set("userName", user.getUserName()).set("passWord", user.getPassWord());
//        //更新查询返回结果集的第一条
//        mongoTemplate.updateFirst(query, update, UserEntity.class);
//        //更新查询返回结果集的所有
//        // mongoTemplate.updateMulti(query,update,UserEntity.class);
//    }
//
//    @Override
//    public void deleteUserById(Long id) {
//        Query query = new Query(Criteria.where("id").is(id));
//        mongoTemplate.remove(query, UserEntity.class);
//    }
//}
