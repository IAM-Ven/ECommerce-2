import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {
  constructor(private httpClient:HttpClient) { }

  login(data) : Observable<any>{
    return this.httpClient.post('http://127.0.0.1:9191/auth', data);
  }
}
