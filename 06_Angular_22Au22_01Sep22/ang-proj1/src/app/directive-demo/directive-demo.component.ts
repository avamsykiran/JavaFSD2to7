import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-directive-demo',
  templateUrl: './directive-demo.component.html',
  styleUrls: ['./directive-demo.component.css']
})
export class DirectiveDemoComponent implements OnInit {

  friendName:string;
  friends:string[];

  constructor() { 
    this.friendName="";
    this.friends=[];
  }

  ngOnInit(): void {
  }

  add(){
    this.friends.push(this.friendName);
    this.friendName="";
  }
}
