import { ModuleWithProviders } from '@angular/core';
import { Routes ,RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { SalesListComponent } from './SalesHistory/sales-list/sales-list.component';
import { ServeListComponent } from './serve-list/serve-list.component';
import { BillingpageComponent } from './billpage/billingpage/billingpage.component';
import { EntrypageComponent } from './entrypage/entrypage/entrypage.component';

export const router:Routes = [
        

        { path: 'serve' , component: ServeListComponent },
        
        { path: 'saleshistory' , component: SalesListComponent },
        
        {path :'billing', component:BillingpageComponent},

        {path :'entrypage', component:EntrypageComponent}
];

export const routes: ModuleWithProviders = RouterModule.forRoot(router);