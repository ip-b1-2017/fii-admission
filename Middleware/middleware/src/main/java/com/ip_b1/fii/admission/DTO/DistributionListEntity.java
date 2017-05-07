package com.ip_b1.fii.admission.DTO;

import java.util.List;

public class DistributionListEntity {
    List<DistributionEntity> distributionList;

    public DistributionListEntity() {
    }

    public List<DistributionEntity> getDistributionList() {
        return distributionList;
    }

    public void setDistributionList(List<DistributionEntity> distributionList) {
        this.distributionList = distributionList;
    }
}
