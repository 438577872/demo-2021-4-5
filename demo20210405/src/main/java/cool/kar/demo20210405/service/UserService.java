package cool.kar.demo20210405.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cool.kar.demo20210405.entity.User;
import cool.kar.demo20210405.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public List<User> findAll() {
        return userMapper.selectList(null);
    }

    public User findById(Integer id) {
        return userMapper.selectById(id);
    }

    public List<User> findByAge(Integer age) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        select * from user where age = {age};
        queryWrapper.eq("age", age);
        return userMapper.selectList(queryWrapper);
    }

    public List<User> findByAgeAndName(Integer age, String name) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        select * from user where age = {age};
        queryWrapper.eq("age", age);
        queryWrapper.eq("name", name);
        return userMapper.selectList(queryWrapper);
    }

    public List<User> findYoungerByAge(Integer age) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lt("age", age);
//        queryWrapper.gt();
//        gt表示大于
//        ge表示大于等于
//        le表示小于等于
        return userMapper.selectList(queryWrapper);
    }

    public List<User> findEmailLeftLikeKey(String key) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeLeft("email", key);
        return userMapper.selectList(queryWrapper);
    }

    public List<User> findEmailRightLikeKey(String key) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("email", key);
        return userMapper.selectList(queryWrapper);
    }

    public List<User> findEmailLikeKey(String key) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("email", key);
        return userMapper.selectList(queryWrapper);
    }

    public List<User> findAgeBetween(Integer left, Integer right) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.between("age", left, right);
        queryWrapper.orderByAsc("age");
        return userMapper.selectList(queryWrapper);
    }

    public Integer insert(Long id, Integer age, String email, String name) {
        User user = new User();
        user.setId(id);
        user.setAge(age);
        user.setEmail(email);
        user.setName(name);
        return userMapper.insert(user);
    }

    public Integer insertNotId(Integer age, String email, String name) {
        User user = new User();
        user.setAge(age);
        user.setEmail(email);
        user.setName(name);
        return userMapper.insert(user);
    }

    public Integer deleteById(Long id) {
        return userMapper.deleteById(id);
    }

    public Integer deleteByMyId(Long id) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        return userMapper.delete(queryWrapper);
    }

    public Integer deleteByAge(Integer age) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("age", age);
//        userMapper.upda
        return userMapper.delete(queryWrapper);
    }


    public Integer updateById(Long id, Integer age, String email, String name){
        User user = new User();
        user.setId(id);
        user.setAge(age);
        user.setEmail(email);
        user.setName(name);
        return userMapper.updateById(user);
    }

}






