import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Product } from './product';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(public http: HttpClient) { }  // DI for HttpClient 


  storeProductInfo(product:Product):Observable<string>{
    // this.http.post("http://localhost:9090/product/storeProduct",product).
    // subscribe(result=>console.log(result),error=>console.log(error));

    return this.http.post("http://localhost:9090/product/storeProduct",product,{responseType:'text'})

    
  }
}
