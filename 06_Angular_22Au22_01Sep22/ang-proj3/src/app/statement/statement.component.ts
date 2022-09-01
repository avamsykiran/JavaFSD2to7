import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AccountHolder } from '../account-holder';
import { AccountHoldersService } from '../account-holders.service';
import { Txn } from '../txn';
import { TxnsService } from '../txns.service';

@Component({
  selector: 'app-statement',
  templateUrl: './statement.component.html',
  styleUrls: ['./statement.component.css']
})
export class StatementComponent implements OnInit {

  ah!:AccountHolder;
  errMsg!:string;
  txns!:Txn[];

  constructor(
    private activatedRoute:ActivatedRoute,
    private ahService:AccountHoldersService,
    private txnService:TxnsService) { }

  ngOnInit(): void {
    let ahId = this.activatedRoute.snapshot.params['id'];

    this.ahService.getById(ahId).subscribe({
      next: data => {
        this.ah=data;
        this.loadBalance();
        this.loadTxns();
      },
      error: err => {console.error(err);this.errMsg="Unable load Account Holder details";}
    })
  }

  loadBalance(){
    this.txnService.getBalance(this.ah.ahId).subscribe({
      next: cb => this.ah.currentBalance=cb,
      error: err => {console.error(err);this.errMsg="Unable load current balance";}    
    })
  }

  loadTxns(){
    this.txnService.getTxns(this.ah.ahId).subscribe({
      next: data => this.txns=data,
      error: err => {console.error(err);this.errMsg="Unable load transactions";}   
    })
  }

}
