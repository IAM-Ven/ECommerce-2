import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TokenInterceptorService implements HttpInterceptor{
  tokenString = sessionStorage.getItem("token");

  constructor() { }
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

      let tokenizedReq = req.clone({
          setHeaders: {
              Authorization: 'Bearer '+ sessionStorage.getItem("token")
          }
        }
      );

      if(this.tokenString != null){
        return next.handle(tokenizedReq);
      }
      else{
        return next.handle(req);
      }
  }
}
