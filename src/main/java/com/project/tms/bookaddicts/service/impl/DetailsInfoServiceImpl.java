package com.project.tms.bookaddicts.service.impl;


import com.project.tms.bookaddicts.pojo.DetailsInfo;
import com.project.tms.bookaddicts.repository.DetailsInfoRepository;
import com.project.tms.bookaddicts.service.DetailsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailsInfoServiceImpl implements DetailsInfoService {

    @Autowired
    private DetailsInfoRepository detailsInfoRepository;

    @Override
    public boolean save(DetailsInfo detailsInfo) {
        detailsInfoRepository.save(detailsInfo);
        return true;
    }

    @Override
    public boolean delete(DetailsInfo detailsInfo) {
        detailsInfoRepository.delete(detailsInfo);

        return true;
    }

    @Override
    public boolean findByBookIdAndUserId(long id, long id2) {
        Long check = detailsInfoRepository.findByBookIdAndUserId(id,id2);
        if(check == null){
            return false;
        }else {
            return true;
        }
    }
}
