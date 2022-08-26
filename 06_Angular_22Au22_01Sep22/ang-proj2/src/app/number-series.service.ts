import { Injectable } from '@angular/core';
import { Observable, Observer } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NumberSeriesService {

  constructor() { }

  geenrateSeries(lb:number,ub:number):Observable<number>{
    
    const job = (observer:Observer<number>) =>{
      if(lb>ub){
        observer.error("Invalid Boundaries! Can not gnerate series");
        return;
      }

      let currentValue = lb;

      let handle = setInterval(()=>{
        observer.next(currentValue);
        currentValue++;
        if(currentValue>ub){
          clearInterval(handle);
          observer.complete();
        }
      },500);
    };

    return new Observable<number>(job);
  }
}
