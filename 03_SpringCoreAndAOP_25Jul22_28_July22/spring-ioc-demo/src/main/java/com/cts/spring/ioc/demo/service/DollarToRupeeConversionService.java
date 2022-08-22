package com.cts.spring.ioc.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DollarToRupeeConversionService implements ConversionService {

	@Value("${dollar.to.rupee:1}")
	private double exchangeRate;
	
	@Value("#{1.0/${dollar.to.rupee:1}}")
	private double reverseExchangeRate;
	
	@Override
	public double convert(double value) {
		return value*exchangeRate;
	}

	@Override
	public double reverseConvert(double value) {
		return value*reverseExchangeRate;
	}

}
