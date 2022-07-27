package com.cuuva.springboot.repository.mapping;

import com.cuuva.springboot.model.EelFarmCommon;

public interface UserInfoMapping {
    String getUserId();
    String getUserPassword();
    EelFarmCommon getEelFarmCommon();
    String getUserName();
    String getUserPhoneNumber();
    String getUserEmail();
}
