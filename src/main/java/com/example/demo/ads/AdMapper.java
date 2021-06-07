package com.example.demo.ads;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdMapper {

    AdDTO toAdDTO(Ad ad);
    Ad toAd(AdDTO adDTO);
}

