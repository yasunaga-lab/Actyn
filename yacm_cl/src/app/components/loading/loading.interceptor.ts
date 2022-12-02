import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {finalize, Observable} from 'rxjs';
import {LoadingService} from "./loading.service";

@Injectable()
export class LoadingInterceptor implements HttpInterceptor {

  constructor(public loadingService: LoadingService) {
  }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    this.loadingService.show();
    return next.handle(request).pipe(finalize(() => this.loadingService.hide()));
  }
}
