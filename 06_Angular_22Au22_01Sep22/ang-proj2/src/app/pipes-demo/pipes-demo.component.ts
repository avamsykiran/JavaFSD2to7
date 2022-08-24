import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pipes-demo',
  templateUrl: './pipes-demo.component.html',
  styleUrls: ['./pipes-demo.component.css']
})
export class PipesDemoComponent implements OnInit {

  strData:string;
  numData:number;
  dateData:Date;

  constructor() { 
    this.strData="Vamsy kiran aripaka";
    this.numData=Math.PI*1000;
    this.dateData=new Date();
  }

  ngOnInit(): void {
  }

}
