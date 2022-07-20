package com.cts.incomestatement.ui;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

import com.cts.incomestatement.exception.InvalidTxnException;
import com.cts.incomestatement.exception.OperationFailedException;
import com.cts.incomestatement.model.Txn;
import com.cts.incomestatement.model.TxnType;
import com.cts.incomestatement.service.TxnService;
import com.cts.incomestatement.service.TxnServiceImpl;

public class TxnUI {

	private TxnService txnService;
	private Scanner scan;
	
	public void run() {
		try {
			this.txnService=new TxnServiceImpl();
		} catch (OperationFailedException e) {
			System.err.println(e.getMessage());
			System.exit(0);
		}
		
		scan = new Scanner(System.in);
		Menu menu=null;
		Menu[] menus = Menu.values();
		
		while(menu!=Menu.QUIT) {
			Arrays.stream(menus).map(m -> m.ordinal()+"\t"+m).forEach(System.out::println);
			System.out.print("Choice: ");
			int ch = scan.nextInt();
			
			if(ch<0||ch>=menus.length) {
				System.out.println("Invalid choice");
				continue;
			}
			
			menu = menus[ch];
			
			switch(menu){
				case LIST:doList(); break;
				case ADD:doAdd();break;
				case REMOVE:doRemove();break;
				case QUIT:System.out.println("App Terminated"); break;
			}
		}
		scan.close();
	}

	private void doList() {
		
		try {
			List<Txn> txns = txnService.getAll();
			
			if(txns.isEmpty()) {
				System.out.println("No Records Yet!");
			}else {
				double totalCredit = txnService.getTotalAmount(txns, TxnType.CREDIT);
				double totalDebit = txnService.getTotalAmount(txns, TxnType.DEBIT);
				double bal = totalCredit-totalDebit;
				
				Consumer<Txn> a= i->{
		            if(i.getType()==TxnType.CREDIT) {
		                System.out.printf(i.getTxnId()+"\t"+i.getTxndate()+"\t"+"%-15s %7.1f %n" ,i.getDesp(),i.getAmount());
		            }
		            else {
		                System.out.printf(i.getTxnId()+"\t"+i.getTxndate()+"\t"+"%-15s %21.1f %n" ,i.getDesp(),i.getAmount());
		            }
		        };
		        
		        System.out.println("TxnID \tTxnDate \tDescription \t Credit \tDebit");
		        System.out.println("------------------------------------------------------------------------------------------------------------------------");
		        txns.stream().forEach(a);
		        System.out.println("------------------------------------------------------------------------------------------------------------------------");
		        System.out.printf("Totals"+ "%41.1f %13.1f %n",totalCredit,totalDebit);
		        System.out.println("------------------------------------------------------------------------------------------------------------------------");
		        System.out.printf("Balance"+ " %54.1f %n",bal);
			}
			
		} catch (OperationFailedException e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	private void doAdd() {
		Txn txn = new Txn();
		System.out.print("Description: ");
		txn.setDesp(scan.next());
		System.out.print("Amount: ");
		txn.setAmount(scan.nextDouble());
		System.out.print("Date(yyyy-MM-dd): ");
		txn.setTxndate(LocalDate.parse(scan.next()));
		System.out.print("Type(CREDIT|DEBIT): ");
		txn.setType(TxnType.valueOf(scan.next()));
		
		try {
			txn = txnService.save(txn);
			System.out.println("Txn saved with id: "+txn.getTxnId());
		} catch (OperationFailedException | InvalidTxnException e) {
			System.err.println(e.getMessage());
		}
	}
	
	private void doRemove() {
		System.out.print("txnId: ");
		int txnId = scan.nextInt();
		
		try {
			txnService.deleteById(txnId);
		} catch (OperationFailedException e) {
			System.err.println(e.getMessage());
		}
	}
}
