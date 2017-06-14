import { Injectable } from '@angular/core';
import { Http,Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'; 
@Injectable()
export class SaleItemdeleteService {

  constructor(private http: Http) { }

getAll(orderid,id):Observable<any>{
  return this.http.get('http://localhost:8080/api/delete/'+orderid+'/'+id)
  .map((response : Response) => response.json());
}
}