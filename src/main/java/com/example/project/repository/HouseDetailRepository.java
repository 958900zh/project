package com.example.project.repository;

import com.example.project.entity.HouseDetail;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HouseDetailRepository extends CrudRepository<HouseDetail, Long> {
    HouseDetail findByHouseId(Long houseId);

    List<HouseDetail> findAllByHouseIdIn(List<Long> houseIds);
}
