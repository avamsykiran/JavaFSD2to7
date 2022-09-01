import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AccountHolder } from './account-holder';

@Injectable({
  providedIn: 'root'
})
export class AccountHoldersService {

  apiUrl:string;

  constructor(private httpClient : HttpClient) {
    //this.apiUrl="http://localhost:9100/";
    this.apiUrl="http://localhost:9999/profiles/";
  }

  getAll():Observable<AccountHolder[]>{
    return this.httpClient.get<AccountHolder[]>(this.apiUrl);
  }

  getById(id:number):Observable<AccountHolder>{
    //return this.httpClient.get<AccountHolder>(`${this.apiUrl}${id}`);
    return this.httpClient.get<AccountHolder>(this.apiUrl + id);
  }

  add(ah:AccountHolder):Observable<AccountHolder>{
    return this.httpClient.post<AccountHolder>(this.apiUrl,ah);
  }

  update(ah:AccountHolder):Observable<AccountHolder>{
    return this.httpClient.put<AccountHolder>(this.apiUrl,ah);
  }
}
