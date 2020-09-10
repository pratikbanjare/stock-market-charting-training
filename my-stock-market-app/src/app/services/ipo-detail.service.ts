import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class IpoDetailService {

  private baseUrl = 'http://localhost:8888/company-services/api/ipos';

  constructor( private http: HttpClient ) { }

  getIpoByCompanyId( companyId : number ): Observable<any> {
    return this.http.get(`${ this.baseUrl }/ ${ companyId}`);
  }

}
