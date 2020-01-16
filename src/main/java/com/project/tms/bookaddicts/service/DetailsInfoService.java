package com.project.tms.bookaddicts.service;


import com.project.tms.bookaddicts.pojo.DetailsInfo;


public interface DetailsInfoService {
    boolean save(DetailsInfo detailsInfo);
    boolean delete(DetailsInfo detailsInfo);
    boolean findByBookIdAndUserId(long id,long id2);
}
