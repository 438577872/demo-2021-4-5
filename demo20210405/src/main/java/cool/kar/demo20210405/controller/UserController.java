package cool.kar.demo20210405.controller;


import cool.kar.demo20210405.entity.User;
import cool.kar.demo20210405.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;


    @RequestMapping("/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }


    @RequestMapping("/findById/{id}")
    public User findById(@PathVariable("id") Integer id) {
        return userService.findById(id);
    }

    @RequestMapping("/findByAge/{age}")
    public List<User> findByAge(@PathVariable("age") Integer age) {
        return userService.findByAge(age);
    }

    @RequestMapping("/findByAgeAndName/{age}/{name}")
    public List<User> findByAgeAndName(@PathVariable("age") Integer age,
                                       @PathVariable("name") String name) {
        return userService.findByAgeAndName(age, name);
    }

    @RequestMapping("/findYoungerByAge/{age}")
    public List<User> findYoungerByAge(@PathVariable("age") Integer age) {
        return userService.findYoungerByAge(age);
    }

    @RequestMapping("/findEmailLeftLikeKey/{key}")
    public List<User> findEmailLeftLikeKey(@PathVariable("key") String key) {
        return userService.findEmailLeftLikeKey(key);
    }


    @RequestMapping("/findEmailRightLikeKey/{key}")
    public List<User> findEmailRightLikeKey(@PathVariable("key") String key) {
        return userService.findEmailRightLikeKey(key);
    }


    @RequestMapping("/findEmailLikeKey/{key}")
    public List<User> findEmailLikeKey(@PathVariable("key") String key) {
        return userService.findEmailLikeKey(key);
    }


    @RequestMapping("/findAgeBetween/{left}/{right}")
    public List<User> findAgeBetween(@PathVariable("left") Integer left,
                                     @PathVariable("right") Integer right) {
        return userService.findAgeBetween(left, right);
    }

    @RequestMapping("/insert/{id}/{age}/{name}/{email}")
    public Map<String, Object> insert(@PathVariable("id") Long id,
                                      @PathVariable("age") Integer age,
                                      @PathVariable("name") String name,
                                      @PathVariable("email") String email) {
        Map<String, Object> map = new HashMap<>();
        try {

            int status = userService.insert(id, age, name, email);
            map.put("status", status);
            map.put("message", "插入成功");
        } catch (Exception e) {
            map.put("status", 0);
            map.put("message", "插入失败");
        }
        return map;
    }

    @RequestMapping("/insertNotId/{age}/{name}/{email}")
    public String insertNotId(
            @PathVariable("age") Integer age,
            @PathVariable("name") String name,
            @PathVariable("email") String email) {
        int status = userService.insertNotId(age, name, email);
        if (status >= 1) {
            return "成功";
        } else {
            return "失败";
        }
    }


    @RequestMapping("/deleteById/{id}")
    public Integer deleteById(@PathVariable("id") Long id) {
        return userService.deleteById(id);
    }

    @RequestMapping("/deleteByMyId/{id}")
    public Integer deleteByMyId(@PathVariable("id") Long id) {
        return userService.deleteByMyId(id);
    }

    @RequestMapping("/updateById/{id}/{age}/{name}/{email}")
    public Integer updateById(@PathVariable("id") Long id,
                              @PathVariable("age") Integer age,
                              @PathVariable("name") String name,
                              @PathVariable("email") String email) {
        return userService.updateById(id, age, name, email);
    }


}
