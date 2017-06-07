import { Component, OnInit } from '@angular/core';
import { SaleListService } from '../salesservice/sale-list.service'
import { SaleItemIdService } from '../salesservice/sale-itemid.service'
@Component({
  selector: 'app-sales-list',
  templateUrl: './sales-list.component.html',
  styleUrls: ['./sales-list.component.css'],
  providers:[SaleListService,SaleItemIdService]
})
export class SalesListComponent implements OnInit {

getDatetime = new Date();

constructor(private salelistserveService: SaleListService, private saleItemIdService : SaleItemIdService) { 

  }

itemid :Array<any>;
items : Array<any>;
status;
 sale=this.status; 
stat = [{name:"Completed"},
          {name:"Open"},
          {name:"cancel"},
          {name:"return"}];

  ngOnInit() {
      this.salelistserveService.getAll().subscribe(
      data => {
        this.items = data;
      },

      error => console.error(error)

    );
  }

onButtonClick(orderid){
  this.saleItemIdService.getAll(orderid).subscribe(
    data => {
      this.itemid = data;
    },
    error => console.error(error)
  );
}

  }
