import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CompanyServiceService {

  private baseUrl = 'http://localhost:8888/company-services/api/company';

  constructor(private http: HttpClient) { }

  getCompany(companyName : string ): Observable<any> {
    return this.http.get(`${this.baseUrl}/name/${companyName}`);
  }

  createCompany ( company : Object ): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, company);
  }

  updateCompany( companyName : string, value : any ) : Observable<Object> {
    return this.http.post(`${this.baseUrl}`, value);
  }
}
