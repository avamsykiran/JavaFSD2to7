import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Txn } from './txn';

@Injectable({
  providedIn: 'root'
})
export class TxnsService {

  apiUrl:string; 
  
  constructor(private httpClient : HttpClient) {
    this.apiUrl="http://localhost:9999/txns/";
  }

  getBalance(ahId:number):Observable<number>{
    return this.httpClient.get<number>(`${this.apiUrl}${ahId}/balance`);
  }  

  getTxns(ahId:number):Observable<Txn[]>{
    let year = (new Date()).getFullYear();
    let start = `${year}-01-01`;
    let end = `${year}-12-31`;
    return this.httpClient.get<Txn[]>(`${this.apiUrl}${ahId}/${start}/${end}`);
  }
  
  add(txn:Txn):Observable<Txn>{
    return this.httpClient.post<Txn>(this.apiUrl,txn);
  }

  update(txn:Txn):Observable<Txn>{
    return this.httpClient.put<Txn>(this.apiUrl,txn);
  }

  delete(txnId:number):Observable<void>{
    return this.httpClient.delete<void>(`${this.apiUrl}${txnId}`);
  }
}
