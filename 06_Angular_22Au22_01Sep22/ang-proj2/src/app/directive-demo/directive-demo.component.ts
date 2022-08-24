import { Component, OnInit } from '@angular/core';
import { GreetService } from '../greet.service';

@Component({
  selector: 'app-directive-demo',
  templateUrl: './directive-demo.component.html',
  styleUrls: ['./directive-demo.component.css']
})
export class DirectiveDemoComponent implements OnInit {

  friendName:string;
  friends:string[];

  constructor(private gs:GreetService) { 
    this.friendName="";
    this.friends=[];
  }

  ngOnInit(): void {
  }

  add(){
    this.friends.push(this.gs.greetUser(this.friendName));
    this.friendName="";
  }
}
