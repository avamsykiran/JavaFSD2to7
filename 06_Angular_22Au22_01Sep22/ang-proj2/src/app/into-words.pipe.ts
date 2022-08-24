import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'intoWords'
})
export class IntoWordsPipe implements PipeTransform {

  digits:string[];

  constructor(){
    this.digits=[
      "ZERO ","ONE ","TWO ","THREE ","FOUR ",
      "FIVE ","SIX ","SEVEN ","EIGHT ","NINE "
    ];
  }

  transform(value: number): string {

    let result='';

    let strValue = `${value}`; //converting number into string

    for(let i=0;i<strValue.length;i++){
      let ch = strValue.charAt(i);
      if(ch=="."){
        result=`${result}DOT `;
      }else{
        let d = parseInt(ch);
        result=`${result}${this.digits[d]}`;
      }
    }

    return result;
  }

}
