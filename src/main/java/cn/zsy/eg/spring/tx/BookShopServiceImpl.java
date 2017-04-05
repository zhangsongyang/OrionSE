package cn.zsy.eg.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

	@Autowired
	private BookShopDao bookShopDao;
	


	@Transactional
	@Override
	public void purchase(String username, String isbn) {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {}

		//1. 获取书的单价
		int price = bookShopDao.findBookPriceByIsbn(isbn);

		//2. 更新数的库存
		bookShopDao.updateBookStock(isbn);

		//3. 更新用户余额
		bookShopDao.updateUserAccount(username, price);
	}

}
