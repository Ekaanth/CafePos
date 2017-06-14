import { Injectable } from '@angular/core';
import { Http,Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'; 
@Injectable()
export class BillingService {

  constructor(private http: Http) { }

postAll(product,totalcost){
   this.http.post('http://localhost:8080/api/addbill/',{product,totalcost})
  .map((response : Response) => response.json());
}
}