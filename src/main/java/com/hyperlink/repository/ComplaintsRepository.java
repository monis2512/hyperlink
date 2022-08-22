package com.hyperlink.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.hyperlink.entity.ComplaintsEntity;

public interface ComplaintsRepository extends PagingAndSortingRepository<ComplaintsEntity, Integer>{

}
