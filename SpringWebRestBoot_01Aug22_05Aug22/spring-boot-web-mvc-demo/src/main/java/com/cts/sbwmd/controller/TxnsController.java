package com.cts.sbwmd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.sbwmd.entity.Txn;
import com.cts.sbwmd.entity.TxnType;
import com.cts.sbwmd.service.TxnService;

@Controller
@RequestMapping("/txns")
public class TxnsController {

	@Autowired
	private TxnService txnService;
	
	@GetMapping("/list")
	public ModelAndView getAllUrlHandler() {
		
		List<Txn> txns = txnService.getAll();
		double totalCredit = txnService.getTotalValue(txns, TxnType.CREDIT);
		double totalDebit = txnService.getTotalValue(txns, TxnType.DEBIT);
		double balance = totalCredit-totalDebit;
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("txns/list-page");
		
		mv.addObject("txns",txns);
		mv.addObject("totalCredit",totalCredit);
		mv.addObject("totalDebit",totalDebit);
		mv.addObject("balance",balance);
		
		return mv;
	}
}
