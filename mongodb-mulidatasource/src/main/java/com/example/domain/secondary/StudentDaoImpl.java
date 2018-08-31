package com.example.domain.secondary;

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
public class StudentDaoImpl implements StudentDao {
    /*
     * 这里使用@Autowired无法区分primaryMongoTemplate和secondaryMongoTemplate
     * @Autowired优先按照类型匹配，若有多个匹配结果，则再按名称匹配，这里为何无法区分？
     */
   @Resource
   private MongoTemplate secondaryMongoTemplate;

    /**
     * 如果不指定集合名，则默认为存储类型的名称
     * 这个例子若不指定集合名，则集合为student
     */
   @Override
   public void saveStudent(Student student) {
       secondaryMongoTemplate.save(student);
       // secondaryMongoTemplate.save(student, "students");
   }

   @Override
   public Student findStudentByName(String name) {
       Query query = new Query(Criteria.where("name").is(name));
       return secondaryMongoTemplate.findOne(query, Student.class);
       // return secondaryMongoTemplate.findOne(query, Student.class, "students");
   }

   @Override
   public void updateStudent(Student student) {
       Query query = new Query(Criteria.where("id").is(student.getId()));
       Update update = new Update().set("name", student.getName());
       //更新查询返回结果集的第一条
       secondaryMongoTemplate.updateFirst(query, update, Student.class);
       // secondaryMongoTemplate.updateFirst(query, update, Student.class, "students");
       //更新查询返回结果集的所有
       // secondaryMongoTemplate.updateMulti(query,update,Student.class);
   }

   @Override
   public void deleteStudentById(Long id) {
       Query query = new Query(Criteria.where("id").is(id));
       secondaryMongoTemplate.remove(query, Student.class);
       // secondaryMongoTemplate.remove(query, Student.class, "students");
   }
}
