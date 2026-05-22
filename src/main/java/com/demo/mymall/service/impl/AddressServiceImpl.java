package com.demo.mymall.service.impl;

import com.demo.mymall.entity.Address;
import com.demo.mymall.mapper.AddressMapper;
import com.demo.mymall.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<Address> findByUserId(int userId){
        return addressMapper.findByUserId(userId);
    }

    @Override
    public void addAddress(Address address){
        addressMapper.insert(address);
    }

    @Override
    public void deleteAddress(Address address){
        addressMapper.delete(address);
    }
    @Override
    public void deleteAddress(int id){
        addressMapper.deleteById(id);
    }


    @Override
    public void updateAddress(Address address){
        addressMapper.update(address);
    }

    @Override
    public void setDefaultAddress(int userId,int id){
        addressMapper.set(userId,id);
    }
}
