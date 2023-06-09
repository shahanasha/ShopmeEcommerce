package com.shopme.admin.banner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.shopme.common.entity.Banner;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class BannerRepositoryTests {
	
	@Autowired
	private BannerRepository bannerRepository;

	@Test
	public void testCreateBanner()
	{
		Banner banner =new Banner();
		banner.setId(2);
		banner.setImage("/banner_2.png");
		banner.setTitle("super DEAL");
		banner.setPrice(600);
        banner.setDescription("NEW product");
        //banner.setLink("shop.commercefox.ml/c/laptop_computers");
        banner.setEnabled(true);
        banner.setLink("shop.commercefox.ml/c/laptop_computers");
        Banner savedBanner =bannerRepository.save(banner);
        System.out.println(savedBanner);
        assertThat(savedBanner).isNotNull();
        assertThat(savedBanner.getId()).isEqualTo(1);
	}
	
	@Test
    public void FindAllBanner(){

        List<Banner> bannerList = bannerRepository.findAll();

        bannerList.forEach(System.out::println);

    }
	
	@Test
    public void findById(){

        Integer id = 1;

        Banner banner = bannerRepository.findById(id).get();

        System.out.println(banner);

    }
	
	@Test
    public void updateBanner(){
        Integer id = 1;
        Banner banner = bannerRepository.findById(id).get();
        banner.setPrice(109);
        bannerRepository.save(banner);
        System.out.println(banner);

    }
}
