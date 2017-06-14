import { Component, OnInit ,Input } from '@angular/core';
import { SaleListService } from '../salesservice/sale-list.service'
import { SaleItemIdService } from '../salesservice/sale-itemid.service'
import { SaleItemdeleteService } from '../salesservice/sale-item-delete.service'
@Component({
  selector: 'app-sales-list',
  templateUrl: './sales-list.component.html',
  styleUrls: ['./sales-list.component.css'],
  providers:[SaleListService,SaleItemIdService,SaleItemdeleteService]
})
export class SalesListComponent implements OnInit {

getDatetime = new Date();

constructor(private salelistserveService: SaleListService, 
            private saleItemIdService : SaleItemIdService,
            private saleItemdeleteService : SaleItemdeleteService) { 

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

onCancelButtonClick(orderid){
  this.saleItemIdService.getAll(orderid).subscribe(
    data => {
      this.itemid = data;
    },
    error => console.error(error)
  );
}


onCrossButtonClicked(orderid,idofitem,id){
   var index = this.itemid.indexOf(id);
  this.itemid.splice(index, 1);
  this.saleItemdeleteService.getAll(orderid,idofitem).subscribe(data => {
      this.itemid = data;
    },
    error => console.error(error)
  );
}


}
