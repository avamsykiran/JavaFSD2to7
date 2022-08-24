import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  userName:string;
  logos:string[];
  logoIndex:number;
  logoWidth:number;
  isCentered:boolean;
  isBorderApplied:boolean;

  constructor() {
    this.userName="Vamsy Kiran";
    this.logos=[
      "assets/imgs/img1.png",
      "assets/imgs/img2.png",
      "assets/imgs/img3.png",
      "assets/imgs/img4.png"
    ];
    this.logoIndex=0;
    this.logoWidth=200;
    this.isBorderApplied=true;
    this.isCentered=true;
  }

  ngOnInit(): void {
  }

  toggle(){
    this.logoIndex++;
    if(this.logoIndex==this.logos.length){
      this.logoIndex=0;
    }
  }
}
