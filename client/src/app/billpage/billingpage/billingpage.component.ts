import { Component, OnInit } from '@angular/core';
import { Contact} from './contacts'
import { Product} from './product'
import { BillingService } from './billing.service'

@Component({
  selector: 'app-billingpage',
  templateUrl: './billingpage.component.html',  
  styleUrls: ['./billingpage.component.css'],
  providers:[BillingService]
})
export class BillingpageComponent implements OnInit {
 
 constructor(private billingService :BillingService){
    this.product = [];
 }

 ngOnInit(){

 }

getDatetime = new Date();

 public tea=0;
 public teaQty=0;
 public teaCost=5;

 public coffee=0;
 public coffeeQty=0;
 public coffeeCost=5;

 public totalCost=0;

 product: Array<Product>;
    

    onClickedTea(){
        if(this.tea==0){
            this.tea++;
            this.teaQty=this.teaQty+1;
            let product = new Product("tea",this.teaQty,this.teaCost);
            this.product.push(product);
            this.totalCost=this.teaCost*this.teaQty+this.coffeeCost*this.coffeeQty;
        }
    }

     onClickedCoffee(){
        if(this.coffee==0){
            this.coffee++;
            this.coffeeQty=this.coffeeQty+1;
            let product = new Product("coffee",this.coffeeQty,this.coffeeCost);
            this.product.push(product);
            this.totalCost=this.teaCost*this.teaQty+this.coffeeCost*this.coffeeQty;
            }
    }

    removeProduct(product){
        let index = this.product.indexOf(product);
        this.product.splice(index,1);
        if(product.name == "coffee"){
            this.coffee=0;
            this.coffeeQty = 0;
        }
        if(product.name == "tea"){
            this.tea=0;
            this.teaQty = 0;
        }
        this.totalCost=this.teaCost*this.teaQty+this.coffeeCost*this.coffeeQty;
    }

    incrementProduct(product){
        if(product.name == "coffee"){
            product.qty =this.coffeeQty+=1;
            product.cost = this.coffeeCost*this.coffeeQty; 
        }
        if(product.name == "tea"){
            product.qty =  this.teaQty+=1;
           product.cost = this.teaCost*this.teaQty; 
           
        }
       this.totalCost=this.teaCost*this.teaQty+this.coffeeCost*this.coffeeQty;
        
    }

    decrementProduct(product){
        if(product.name == "coffee"){    
            
            if(product.qty == 1){
                this.removeProduct(product);
                this.coffeeQty=0;
            }
            else{
             product.qty =  this.coffeeQty-=1;
             product.cost = this.coffeeCost*this.coffeeQty; 
            }
        }
        if(product.name == "tea"){
           
           if(product.qty == 1){
                this.removeProduct(product);
                this.teaQty=0;
            }else{
            product.qty =  this.teaQty-=1;
           product.cost = this.teaCost*this.teaQty; 
            }
        }
        this.totalCost=this.teaCost*this.teaQty+this.coffeeCost*this.coffeeQty;
    }

    onSubmit(product,totalCost){
        this.billingService.postAll(product,totalCost);
    }
}

