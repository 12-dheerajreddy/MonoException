package com.example.demo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ReInstallDao;
import com.example.demo.bean.ReInstallApp;

import ch.qos.logback.classic.Logger;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple3;

@Service
public class ReInstallService {

	Mono<Integer> UpdateRecord1 = null;
	Mono<Integer> SaveRecord1 = null;

	@Autowired
	public ReInstallDao rid;

	boolean flag = false;

	public Mono<ReInstallApp> GetReInstall(ReInstallApp rea) {

		Integer orderNumber = rea.getOrderNumber();

		Mono<ReInstallApp> just = rid.getByOrderId(orderNumber);

		// Mono<ReInstallApp> just = Mono.just(byOrderId);

		return just.flatMap(x -> {
			if (x.getOrderNumber() != null) {
				flag = true;
				x.setInstallationType("re-install");
				x.setCurrentDate("date");

			} else {
				// flag=false;
				x.setOrderNumber(rea.getOrderNumber());
				x.setLocationCode(rea.getLocationCode());
				x.setMtnNo(rea.getMtnNo());
				x.setInstallationType("update");
				x.setCurrentDate("create date");
			}

			Mono<Integer> UpdateRecord1 = Mono.just(0);
			Mono<Integer> SaveRecord1 = Mono.just(0);

			/*
			 * WirelessApp.flatMap(dhe->{ if(flag) { Mono<Integer> UpfixedWirelessDao =
			 * rid.fixedWirelessDao(dhe); return UpfixedWirelessDao; } else { Mono<Integer>
			 * savfixedWirelessDao = rid.fixedWirelessDao(dhe); return savfixedWirelessDao;
			 * }
			 * 
			 * Mono<Tuple3<Integer,Integer,ReInstallApp>>
			 * receptzip=Mono.zip(UpfixedWirelessDao, savfixedWirelessDao,Mono.just(rea));
			 * 
			 * 
			 * return receptzip.flatMap(resp->{ return Mono.empty().then(); });
			 * 
			 * 
			 * });
			 */

			if (flag) {
				UpdateRecord1 = rid.fixedWirelessDao(x);

			} else {
				SaveRecord1 = rid.fixedWirelessDao(x);

			}
			Mono<Tuple3<Integer, Integer, ReInstallApp>> receptzip = Mono.zip(UpdateRecord1, SaveRecord1,
					Mono.just(rea));

			return receptzip.flatMap(resp -> {

				return Mono.empty();
			});
		});

		// return Mono.just(x);
		// });

		/*
		 * return byOrderId.flatMap(x->{ if(x.getOrderNumber()==null) {
		 * System.out.println("there is no order number"); } return Mono.just(x); });
		 */

		// return null;

	}

}
