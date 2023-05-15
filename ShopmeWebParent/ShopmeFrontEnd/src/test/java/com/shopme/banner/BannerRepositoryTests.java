package com.shopme.banner;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.shopme.common.entity.Banner;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class BannerRepositoryTests {
	
	@Autowired
	private BannerRepository repo;
	
	@Test
	public void testListEnabledBanners() {
		List<Banner>  banners= repo.findAllEnabled();
		banners.forEach(banner ->{
			System.out.println(banner.getTitle()+ "("+ banner.isEnabled()+")");
		});
	}

}
