package kr.co.recipetoyou.admin.adsend.adsms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("smsService")
public class AdSmsServiceImpl implements AdSmsService {

	@Autowired
	private AdSmsDAO smsDAO;
}
