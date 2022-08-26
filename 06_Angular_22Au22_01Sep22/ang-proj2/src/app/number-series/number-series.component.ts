import { Component, OnInit } from '@angular/core';
import { NumberSeriesService } from '../number-series.service';

@Component({
  selector: 'app-number-series',
  templateUrl: './number-series.component.html',
  styleUrls: ['./number-series.component.css']
})
export class NumberSeriesComponent implements OnInit {

  lb:number;
  ub:number;

  err!:string|null;
  results!:number[];
  isJobDone:boolean;

  constructor(private nss:NumberSeriesService) {
    this.lb=0;
    this.ub=0;
    this.isJobDone=true;
  }

  ngOnInit(): void {
  }

  formSubmitted(){
    this.results=[];
    this.err=null;
    this.isJobDone=false;

    this.nss.geenrateSeries(this.lb,this.ub).subscribe({
      next: val => this.results.push(val),
      error: error => {this.err=error;this.isJobDone=true;},
      complete: () => this.isJobDone=true
    })
  }

}
