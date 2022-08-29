import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AccountHolder } from '../account-holder';
import { AccountHoldersService } from '../account-holders.service';

@Component({
  selector: 'app-account-holder-form',
  templateUrl: './account-holder-form.component.html',
  styleUrls: ['./account-holder-form.component.css']
})
export class AccountHolderFormComponent implements OnInit {

  isNew:boolean;
  ah:AccountHolder;
  errMsg!:string;

  constructor(
      private ahsService:AccountHoldersService,
      private router:Router,
      private activatedRoute:ActivatedRoute) {
        this.isNew=true;
        this.ah={ahId:0,firstName:'',lastName:'',mailId:'',mobile:''};
  }

  ngOnInit(): void {
    let ahId = this.activatedRoute.snapshot.params['id'];

    if(ahId){
      this.isNew=false;
      this.ahsService.getById(ahId).subscribe({
        next: data => this.ah=data,
        error: err => {console.error(err);this.errMsg="Coudl not read the record!"}
      });
    }
  }

  save(){
    let obr:Observable<AccountHolder> = 
        this.isNew?
          this.ahsService.add(this.ah) :
          this.ahsService.update(this.ah) ;
    
    obr.subscribe({
      next: data => this.router.navigateByUrl("/list"),
      error: err => {console.error(err);this.errMsg="Unable to save record! Please try later";}
    });
    
  }
}
