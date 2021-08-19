package com.sxlg.service.Impl;

import com.sxlg.bean.AssetInformation;
import com.sxlg.mapper.AssetInformationMapper;
import com.sxlg.service.AssetInformationService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetInformationServiceImpl implements AssetInformationService {
    @Autowired
    private AssetInformationMapper mapper;

    public List<AssetInformation> selectAll(){
        List<AssetInformation> list =  mapper.selectList(null);
        if(list!=null){
            for(AssetInformation assetInformation: list){
                assetInformation.setName(mapper.selectReviewer(assetInformation.getReviewer()));
            }
        }
        return list;
    }

    @Override
    public int delete(Long id) {
         return mapper.deleteById(id);
    }

    @Override
    public int  insert(AssetInformation assetInformation) {
       return  mapper.insert(assetInformation);
    }

    @Override
    public void update(AssetInformation assetInformation) {
        mapper.updateById(assetInformation);
    }


}
