import { Injectable } from '@angular/core';
import { Http,Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'; 
@Injectable()
export class SaleItemIdService {

  constructor(private http: Http) { }

getAll(id):Observable<any>{
  return this.http.get('http://localhost:8080/api/findbyid/'+id)
  .map((response : Response) => response.json());
}
}
