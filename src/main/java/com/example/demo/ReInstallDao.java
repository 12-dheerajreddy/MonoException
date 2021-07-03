package com.example.demo;

import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.ReInstallApp;

import reactor.core.publisher.Mono;

@Repository
public class ReInstallDao {
	
	private static String RETRIVE_QUERY="select * from FixedWireless where orderNumber=?";
	private static String INSERT_QUERY="INSERT INTO FixedWireless(locationCode,orderNumber,mtnNo,installationType,currentDate) values(?,?,?,?,?)";
	
	  @Autowired
	 private JdbcTemplate jt;

	public Mono<ReInstallApp> getByOrderId(Integer orderNumber) {
		
		ReInstallApp queryForObject = jt.queryForObject(RETRIVE_QUERY,new Object[] {orderNumber} ,(rs,RowMap)->{
		
			if(rs!=null&&RowMap>=1) {
				return new ReInstallApp(rs.getInt("locationCode"),rs.getInt("orderNumber"),rs.getInt("mtnNo"),rs.getString("installationType"),rs.getString("currentDate"));
				}
			return new ReInstallApp();
			});
//		
	return Mono.just(queryForObject);
//		
		}
	
		/*
		 * private Mono<ReInstallApp> populateResponse(ResultSet rs){
		 * 
		 * return null; }
		 */
	public Mono<Integer> fixedWirelessDao(ReInstallApp ri) {
		int update = jt.update(INSERT_QUERY, ri.getOrderNumber(),ri.getLocationCode(),ri.getMtnNo(),ri.getInstallationType(),ri.getCurrentDate());
		
		Mono<Integer> just = Mono.just(update);
		return just;
	}
	
	
	
		
	/*	finally {
			ReInstallApp rs=new ReInstallApp();
			rs.setOrderNumber(null);
			Mono<ReInstallApp> just = Mono.just(rs);
			return just;
		}*/
	}
	


