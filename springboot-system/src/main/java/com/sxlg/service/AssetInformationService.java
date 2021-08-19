package com.sxlg.service;

import com.sxlg.bean.AssetInformation;

import java.util.List;

public interface AssetInformationService {
    List<AssetInformation> selectAll();
    int delete(Long id);
    int insert(AssetInformation assetInformation);
    void update(AssetInformation assetInformation);
}
