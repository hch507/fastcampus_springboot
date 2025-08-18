package com.example.cours3_ch4.db;

import com.example.cours3_ch4.entity.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

abstract public class SimpleDataRepository<T extends Entity, ID extends Long> implements DataRepository<T, ID> {

    private List<T> dataList = new ArrayList<T>();

    private static long index = 0;


    @Override
    public T save(T data) {

        if (Objects.isNull(data)) {
            throw new RuntimeException("data is null");
        }

        // db에 데이터가 있는가
        var preData = dataList.stream()
                .filter(it -> {
                    return it.getId().equals(data.getId());
                })
                .findFirst();

        if (preData.isPresent()) { // 기존 데이터가 있는 경우
            dataList.remove(preData);
            dataList.add(data);
        } else {// 새로운 데이터 저장
            index++;
            data.setId(index);
            dataList.add(data);
        }


        return null;
    }

    @Override
    public List<T> findAll() {
        return dataList;
    }

    @Override
    public Optional<T> findById(ID id) {

        return dataList.stream()
                .filter(it -> {
                    return (it.getId().equals(id));
                }).findFirst();
    }

    @Override
    public void delete(ID id) {
        var deleteEntity =dataList.stream()
                .filter(it -> {
                    return (it.getId().equals(id));
                }).findFirst();

        if (deleteEntity.isPresent()){
            dataList.remove(deleteEntity);
        }
    }
}
