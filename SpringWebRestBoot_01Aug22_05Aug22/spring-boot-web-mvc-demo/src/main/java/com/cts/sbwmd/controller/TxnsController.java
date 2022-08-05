package com.cts.sbwmd.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.sbwmd.entity.Txn;
import com.cts.sbwmd.entity.TxnType;
import com.cts.sbwmd.exception.NotInsertableTxnException;
import com.cts.sbwmd.exception.NotUpdatableTxnException;
import com.cts.sbwmd.exception.TxnNotFoundException;
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
		double balance = totalCredit - totalDebit;

		ModelAndView mv = new ModelAndView();
		mv.setViewName("txns/list-page");

		mv.addObject("txns", txns);
		mv.addObject("totalCredit", totalCredit);
		mv.addObject("totalDebit", totalDebit);
		mv.addObject("balance", balance);

		return mv;
	}

	@GetMapping("/delete")
	public String deleteHandler(@RequestParam("id") Long txnId) throws TxnNotFoundException {
		txnService.deleteById(txnId);
		return "redirect:/txns/list";
	}

	@GetMapping("/add")
	public ModelAndView addHandler() {
		return new ModelAndView("txns/txn-form-page", "txn", new Txn());
	}

	@PostMapping("/add")
	public ModelAndView saveHandler(@ModelAttribute("txn") @Valid Txn txn, BindingResult bindingResults)
			throws NotInsertableTxnException {
		ModelAndView mv = null;

		if (bindingResults.hasErrors()) {
			mv = new ModelAndView("txns/txn-form-page", "txn", txn);
		} else {
			txnService.add(txn);
			mv = new ModelAndView("redirect:/txns/list");
		}

		return mv;
	}

	@GetMapping("/edit")
	public ModelAndView editHandler(@RequestParam("id") Long txnId) throws TxnNotFoundException {
		return new ModelAndView("txns/txn-form-page", "txn", txnService.getById(txnId));
	}
	
	@PostMapping("/edit")
	public ModelAndView updateHandler(@ModelAttribute("txn") @Valid Txn txn, BindingResult bindingResults)
			throws NotUpdatableTxnException, TxnNotFoundException {
		ModelAndView mv = null;

		if (bindingResults.hasErrors()) {
			mv = new ModelAndView("txns/txn-form-page", "txn", txn);
		} else {
			txnService.update(txn);
			mv = new ModelAndView("redirect:/txns/list");
		}

		return mv;
	}	
}
