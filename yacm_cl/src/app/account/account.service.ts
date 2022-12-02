import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Endpoint} from "../constant/constant";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  httpOption = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  registrationResult?: Object | HttpErrorResponse;

  constructor(private http: HttpClient) {
  }

  registerMail(body: any): Observable<any> {
    let url: string = environment.serverURI + Endpoint.registerMail;
    return this.http.post(url, body, this.httpOption);
  }

  async registerCS(body: string): Promise<void> {
    let url: string = environment.serverURI + Endpoint.registerCS;
    console.log('post: ' + url + '\nbody:' + '\n' + body);
    let registrationResult: Object | HttpErrorResponse;
    return new Promise((resolve) => {
      this.http.post(url, body, this.httpOption).subscribe({
        next(result: Object) {
          registrationResult = result;
          console.log(registrationResult);
        },
        error(err: HttpErrorResponse) {
          registrationResult = err;
          console.log(err);
        }
      }).add(() => {
        this.registrationResult = registrationResult;
        resolve();
      });
    });
  }
}
