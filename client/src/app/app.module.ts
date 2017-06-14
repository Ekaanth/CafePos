import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { ServeService } from './serve/serve.service';

import { routes } from './app.router';
import { AppComponent } from './app.component';
import { ServeListComponent } from './serve-list/serve-list.component';
import { SalesListComponent } from './SalesHistory/sales-list/sales-list.component';
import { BillingpageComponent } from './billpage/billingpage/billingpage.component';

@NgModule({
  declarations: [
    AppComponent,
    ServeListComponent,
    SalesListComponent,
    BillingpageComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routes
  ],
  providers: [ServeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
