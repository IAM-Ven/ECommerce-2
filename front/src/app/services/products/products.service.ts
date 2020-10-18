import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor(private httpClient:HttpClient) { }


  getAllProducts() : Observable<any>{
    return this.httpClient.get('http://127.0.0.1:9191/products/all');
  }

}
