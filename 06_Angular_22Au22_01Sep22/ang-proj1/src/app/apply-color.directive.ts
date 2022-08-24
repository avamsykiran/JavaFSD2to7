import { Directive, ElementRef, Input, OnInit, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appApplyColor]'
})
export class ApplyColorDirective implements OnInit {

  @Input('appApplyColor')
  friendName!:string;

  constructor(private ele:ElementRef,private renderer:Renderer2) { 

  }

  ngOnInit(): void {
      
    let color = this.friendName.length>10?'#ff0000':'#0000ff';

    this.renderer.setStyle(this.ele.nativeElement,"background-color",color);

  }
}
