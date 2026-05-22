package com.demo.mymall.service;

import com.demo.mymall.entity.Address;

import java.util.List;

public interface AddressService {

    // 根据用户ID查询地址列表
    List<Address> findByUserId(int userId);

    // 新增地址
    void addAddress(Address address);

    // 删除地址
    void deleteAddress(Address address);
    void deleteAddress(int id);

    // 修改地址
    void updateAddress(Address address);

    // 设置默认地址
    void setDefaultAddress(int userId,int id);
}
