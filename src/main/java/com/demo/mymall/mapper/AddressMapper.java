package com.demo.mymall.mapper;

import com.demo.mymall.entity.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressMapper {

    List<Address> findByUserId(int userId);

    void insert(Address address);
    void update(Address address);
    void delete(Address address);
    void deleteById(int id);
    void set(int userId, int id);
}