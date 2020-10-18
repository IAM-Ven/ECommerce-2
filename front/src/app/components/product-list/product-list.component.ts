import { Component, OnInit } from '@angular/core';
import { ProductsService } from 'src/app/services/products/products.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  items = [];
  pageOfItems: Array<any>;

  constructor(private productService: ProductsService) { }

  ngOnInit() {
      // an example array of 150 items to be paged
      //this.items = Array(150).fill(0).map((x, i) => ({ id: (i + 1), name: `Item ${i + 1}`}));
      
      this.productService.getAllProducts().subscribe( result=>{
        console.log(result);
        this.items=result;
      })
  }

  onChangePage(pageOfItems: Array<any>) {
      // update current page of items
      this.pageOfItems = pageOfItems;
  }

}
