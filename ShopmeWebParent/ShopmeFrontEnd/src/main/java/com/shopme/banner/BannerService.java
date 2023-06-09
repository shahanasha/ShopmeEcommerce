package com.shopme.banner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopme.common.entity.Banner;

import java.util.List;

@Service
public class BannerService {

    @Autowired
    private BannerRepository bannerRepository;


    public List<Banner> getAllBanners() {
        List<Banner> listEnabledBanners = bannerRepository.findAllEnabled();
//        listEnabledBanners.forEach(banner ->{
//        	
//        });
//        for (Banner banner : banners) {
//            if (banner.getId().equals(4)) {
//               int index = banners.indexOf(banner);
//                System.out.println(banners);
//                banners.remove(index);
//            }
//        }

        return listEnabledBanners;
    }

    public Banner getFullWidthBanner(){
        Banner banner = bannerRepository.findById(4).get();
        return banner;
    }
}