package com.demo.mymall.controller;

import com.demo.mymall.entity.Address;
import com.demo.mymall.entity.User;
import com.demo.mymall.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/address/list")
    @ResponseBody
    public List<Address> getAddressList(HttpSession session) {
        User user = (User) session.getAttribute("loginUser");
        if (user == null) {
            return null;  // 未登录返回空
        }
        return addressService.findByUserId(user.getId());
    }

    @PostMapping("/address/add")
    @ResponseBody
    public Map<String, Object> addAddress(@RequestBody Address address, HttpSession session) {
        Map<String, Object> result = new HashMap<>();

        // 获取当前登录用户
        User user = (User) session.getAttribute("loginUser");
        if (user == null) {
            result.put("success", false);
            result.put("message", "请先登录");
            return result;
        }

        // 设置用户ID
        address.setUserId(user.getId());

        try {
            addressService.addAddress(address);
            result.put("success", true);
            result.put("message", "地址添加成功");
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "添加失败：" + e.getMessage());
        }
        return result;
    }

    @PostMapping("/address/delete")
    @ResponseBody
    public Map<String, Object> deleteAddress(@RequestParam int id, HttpSession session) {
        Map<String, Object> result = new HashMap<>();

        User user = (User) session.getAttribute("loginUser");
        if (user == null) {
            result.put("success", false);
            result.put("message", "请先登录");
            return result;
        }

        try {
            addressService.deleteAddress(id);
            result.put("success", true);
            result.put("message", "删除成功");
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "删除失败");
        }
        return result;
    }

    @PostMapping("/address/update")
    @ResponseBody
    public Map<String, Object> updateAddress(@RequestBody Address address, HttpSession session) {
        Map<String, Object> result = new HashMap<>();

        User user = (User) session.getAttribute("loginUser");
        if (user == null) {
            result.put("success", false);
            result.put("message", "请先登录");
            return result;
        }

        try {
            addressService.updateAddress(address);
            result.put("success", true);
            result.put("message", "修改成功");
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "修改失败");
        }
        return result;
    }

    @PostMapping("/address/setDefault")
    @ResponseBody
    public Map<String, Object> setDefault(@RequestParam int id, HttpSession session) {
        Map<String, Object> result = new HashMap<>();

        User user = (User) session.getAttribute("loginUser");
        if (user == null) {
            result.put("success", false);
            result.put("message", "请先登录");
            return result;
        }

        try {
            addressService.setDefaultAddress(user.getId(), id);
            result.put("success", true);
            result.put("message", "设置成功");
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "设置失败");
        }
        return result;
    }
}