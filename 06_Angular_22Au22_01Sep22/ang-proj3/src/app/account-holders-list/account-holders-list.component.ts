import { Component, OnInit } from '@angular/core';
import { AccountHolder } from '../account-holder';
import { AccountHoldersService } from '../account-holders.service';

@Component({
  selector: 'app-account-holders-list',
  templateUrl: './account-holders-list.component.html',
  styleUrls: ['./account-holders-list.component.css']
})
export class AccountHoldersListComponent implements OnInit {

  ahs!:AccountHolder[];
  errMsg!:string;

  constructor(private ahsService: AccountHoldersService) { }

  ngOnInit(): void {
    this.ahsService.getAll().subscribe({
      next: data => this.ahs=data,
      error: err => {console.error(err);this.errMsg="Unable to load data! Please try later";}
    });
  }

}
