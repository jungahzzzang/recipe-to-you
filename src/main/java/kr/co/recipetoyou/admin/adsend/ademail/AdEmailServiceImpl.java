package kr.co.recipetoyou.admin.adsend.ademail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("emailService")
public class AdEmailServiceImpl implements AdEmailService {

	@Autowired
	private AdEmailDAO emailDAO;
}
