import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SignUpService {

  constructor(private httpClient:HttpClient) { }

  signUp(data) : Observable<any>{
    return this.httpClient.put('http://127.0.0.1:9191/signup', data);
  }
}
