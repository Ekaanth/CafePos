import { ModuleWithProviders } from '@angular/core';
import { Routes ,RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { SalesListComponent } from './SalesHistory/sales-list/sales-list.component';
import { ServeListComponent } from './serve-list/serve-list.component';

export const router:Routes = [
        

        { path: 'serve' , component: ServeListComponent },
        
        { path: 'saleshistory' , component: SalesListComponent }
        
];

export const routes: ModuleWithProviders = RouterModule.forRoot(router);