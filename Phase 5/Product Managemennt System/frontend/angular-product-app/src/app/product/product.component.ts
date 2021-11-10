import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  insertMsg:string="";
  constructor(public productSer:ProductService) { } // DI for Service class 

  ngOnInit(): void {
  }

  storeProduct(productRef:NgForm){
    let product = productRef.value;
    console.log(product);
      this.productSer.storeProductInfo(product).
      subscribe(result=>this.insertMsg=result,error=>console.log(error));
    productRef.reset();
  }
}
