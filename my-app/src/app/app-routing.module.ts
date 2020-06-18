import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login/login.component';
import { BodyComponent } from './body/body.component';
import { RegisterComponent } from './login/register/register.component';
import { DepartmentComponent } from './body/department/department.component';
import { AdminComponent } from './body/admin/admin.component';
import { CartComponent } from './body/cart/cart.component';
import { PurchaseComponent } from './body/purchase/purchase.component';
import { MealkitsComponent } from './body/department/mealkits/mealkits.component';


const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full'},
  { path: 'login', component: LoginComponent},
  { path: 'register', component: RegisterComponent},
  { path: 'home', component: BodyComponent},
  { path: 'department', component: DepartmentComponent},
  { path: 'admin', component: AdminComponent},
  { path: 'cart', component: CartComponent},
  { path: 'checkout', component: PurchaseComponent},
  { path: 'meal-kits', component: MealkitsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
