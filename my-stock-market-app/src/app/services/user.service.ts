import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user';

const httpOptions = {
  headers : new HttpHeaders(  {'content-type': 'applicaiton/json'} )  
}

@Injectable({
  providedIn: 'root'
})
export class UserService {


  private baseurl = 'localhost:8085/api/users';
  constructor( private http: HttpClient ) { }

  getUserByName  (username : string ) : Observable<Object> {
    return this.http.get ( `${this.baseurl}/name/${username}`, { responseType : 'json'});
  }

  getAllUseres ( ) : Observable<any>{
    return this.http.get ( this.baseurl );
  }

  getHello () : Observable<any> {
    return this.http.get ( "http://localhost:8085/api/hello", {responseType : 'text'});
  }

}
